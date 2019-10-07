package com.lin.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.BlockEntity;
import com.lin.entity.NextEntity;

@Repository
public class NextDao extends BaseDao {
	public List<NextEntity> findFromTempByBlock(int block) {
		return template.selectList("nextDao.findFromTempByBlock", block);
	}

	public boolean addToTemp(NextEntity entity) {
		return template.insert("nextDao.addToTemp", entity) > 0;
	}

	public boolean updateToTemp(NextEntity entity) {
		return template.update("nextDao.updateToTemp", entity) > 0;
	}

	public NextEntity findFromTempById(int id) {
		// TODO Auto-generated method stub
		return template.selectOne("nextDao.findFromTempById", id);
	}

	public List<NextEntity> findFromTempByProcess(int processId) {
		return template.selectList("nextDao.findFromTempByProcess", processId);
	}

	public void deleteFromTempByBlockAndValue(Integer block, Integer value, Integer id) {
		HashMap map = new HashMap();
		map.put("block", block);
		map.put("value", value);
		map.put("id", id);
		template.delete("nextDao.deleteFromTempByBlockAndValue", map);

	}

	public boolean deleteFromTemp(Integer nextId) {
		// TODO Auto-generated method stub
		return template.delete("nextDao.deleteFromTemp", nextId) > 0;
	}
}
