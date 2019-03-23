package com.lin.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.constants.BlockConstant;
import com.lin.dao.BlockDao;
import com.lin.dao.ExecuteDao;
import com.lin.dao.ExecuteParamDao;
import com.lin.dao.ProcessArgumentDao;
import com.lin.entity.BlockEntity;
import com.lin.entity.ExecuteParamEntity;
import com.lin.entity.ProcessArgumentEntity;
import com.lin.request.req.GetParamByBlocksReq;
import com.lin.request.req.GetSingleBlockInfoReq;
import com.lin.request.req.SaveNextReq;
import com.lin.request.req.SaveOrUpdateBlockReq;
import com.lin.request.req.UpdateBlockPositionReq;
import com.lin.request.resp.GetParamByBlocksResp;
import com.lin.request.resp.GetSingleBlockInfoResp;
import com.lin.request.resp.SaveNextResp;
import com.lin.request.resp.SaveOrUpdateBlockResp;
import com.lin.request.resp.UpdateBlockPositionResp;
import com.lin.service.BlockService;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

	@Autowired
	BlockDao blockDao;

	@Autowired
	ExecuteDao executeDao;

	@Autowired
	ExecuteParamDao executeParamDao;

	@Autowired
	ProcessArgumentDao processArgumentDao;

	@Override
	public void getSingleBlockInfo(GetSingleBlockInfoReq req, GetSingleBlockInfoResp resp) {
		// TODO Auto-generated method stub
		BlockEntity be = blockDao.findFromTempById(req.getBlockId());
		resp.setBlock(be);
	}

	@Override
	public void saveOrUpdateBlock(SaveOrUpdateBlockReq req, SaveOrUpdateBlockResp resp) {
		// TODO Auto-generated method stub
		BlockEntity block = new BlockEntity();
		if (req.getBlock() != null && req.getBlock() > 0) {
			block = blockDao.findFromTempById(req.getBlock());
		}

		block.setName(req.getName());
		block.setProcess(req.getProcess());
		if (req.getBlock() != null && req.getBlock() > 0) {
			blockDao.updateToTemp(block);
		} else {
			blockDao.addToTemp(block);
		}
		
		resp.setBlock(block);
	}

	@Override
	public void getParamByBlocks(GetParamByBlocksReq req, GetParamByBlocksResp resp) {
		// TODO Auto-generated method stub
		HashSet<String> mainSet = new HashSet<String>();
		boolean isInit = false;
		for (List<Integer> blocks : req.getBlocks()) {
			HashSet<String> set = new HashSet<String>();
			List<ExecuteParamEntity> params = executeParamDao.findFromTempByBlocks(blocks);
			for (ExecuteParamEntity e : params) {
				set.add(e.getParam());
			}

			if (isInit) {
				mainSet.addAll(set);
			} else {
				mainSet.retainAll(set);
			}
		}

		List<ProcessArgumentEntity> args = processArgumentDao.findFromTempByProcess(req.getProcessId());
		for (ProcessArgumentEntity arg : args) {
//			if (arg.getType() == BlockConstant.args_type_output) {
				mainSet.add(arg.getName());
//			}
		}
		resp.setSets(mainSet);

	}

	@Override
	public void updateBlockPosition(UpdateBlockPositionReq req, UpdateBlockPositionResp resp) {
		// TODO Auto-generated method stub
		BlockEntity block = blockDao.findFromTempById(req.getBlock());
		block.setPositionX(req.getPositionX());
		block.setPositionY(req.getPositionY());
		blockDao.updateToTemp(block);
	}

}
