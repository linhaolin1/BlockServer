package com.lin.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.BlockEntity;
import com.lin.entity.ExecuteEntity;

@Repository
public class ExecuteDao extends BaseDao {

	public List<ExecuteEntity> findFromTempByBlock(int blockId) {
		return template.selectList("executeDao.findFromTempByBlock", blockId);
	}

	public boolean addToTemp(ExecuteEntity entity) {
		return template.insert("executeDao.addToTemp", entity) > 0;
	}

	public boolean updateToTemp(ExecuteEntity entity) {
		return template.update("executeDao.updateToTemp", entity) > 0;
	}

	public boolean deleteFromTemp(Integer id) {
		return template.delete("executeDao.deleteFromTemp", id) > 0;
	}

	public ExecuteEntity findFromTempById(int id) {
		// TODO Auto-generated method stub
		return template.selectOne("executeDao.findFromTempById", id);
	}

	public List<ExecuteEntity> findFromTempByBlocks(List<BlockEntity> blocks) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (BlockEntity be : blocks) {
			sb.append(be.getId() + ",");
		}
		sb.setLength(sb.length() - 1);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("blocks", sb.toString());
		return template.selectList("executeDao.findFromTempByBlocks", map);
	}

	public List<ExecuteEntity> findFromTempByBlocksId(List<Integer> blocks) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (Integer be : blocks) {
			sb.append(be + ",");
		}
		sb.setLength(sb.length() - 1);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("blocks", sb.toString());
		return template.selectList("executeDao.findFromTempByBlocks", map);
	}

	public List<ExecuteEntity> findFromTempByProcess(Integer processId) {
		// TODO Auto-generated method stub
		return template.selectList("executeDao.findFromTempByProcess", processId);
	}
}
