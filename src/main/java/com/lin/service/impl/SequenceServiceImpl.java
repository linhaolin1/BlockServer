package com.lin.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.constants.BlockConstant;
import com.lin.dao.SequenceRecordDao;
import com.lin.service.SequenceService;
import com.lin.util.RedisManager;

import redis.clients.jedis.Jedis;

@Service
@Transactional
@Configuration("database.properties")
public class SequenceServiceImpl implements SequenceService {

	private ExecutorService executor;

	@Autowired
	private SequenceRecordDao sequenceDao;

	@Autowired
	RedisManager redis;

	public SequenceServiceImpl() {
		executor = Executors.newFixedThreadPool(10);
	}

	@Override
	public Long genpProcessSequence(final int processId) {
		// TODO Auto-generated method stub
		System.out.println("redis incr key=" + BlockConstant.REDIS_SEQUENCE_PROCESS + processId);
		Long sequenceId = redis.incr(BlockConstant.REDIS_SEQUENCE_PROCESS + processId);
		return sequenceId;
	}

	@Override
	public void save(final String string, final Long sequenceId, final Long time, final int processId,
			final int blockId, final Integer executeId, final String remark) {
		// TODO Auto-generated method stub
		executor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sequenceDao.addNewRecord(string, sequenceId, time, processId, blockId, executeId, remark);
			}
		});
	}

}
