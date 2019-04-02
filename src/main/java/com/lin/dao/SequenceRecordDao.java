package com.lin.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class SequenceRecordDao extends BaseDao {
	public void addNewRecord(final String string, final Long sequenceNumm, final Long time, final Integer processId,
			final Integer blockId, final Integer executeId, String remark) {
		HashMap map = new HashMap();
		map.put("name", string);
		map.put("sequenceNumm", sequenceNumm);
		map.put("time", time);
		map.put("processId", processId);
		map.put("blockId", blockId);
		map.put("executeId", executeId);
		map.put("remark", remark);

		template.insert("sequenceDao.add", map);
	}
}
