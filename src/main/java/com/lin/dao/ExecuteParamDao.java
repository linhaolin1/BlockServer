package com.lin.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.BlockEntity;
import com.lin.entity.ExecuteParamEntity;

@Repository
public class ExecuteParamDao extends BaseDao {
	public List<ExecuteParamEntity> findMethodParamFromTempByExecute(int execute) {
		return template.selectList("executeParamDao.findMethodParamFromTempByExecute", execute);
	}

	public ExecuteParamEntity findMethodReturnParamFromTempByExecute(int execute) {
		return template.selectOne("executeParamDao.findMethodReturnParamFromTempByExecute", execute);
	}

	public boolean addToTemp(ExecuteParamEntity entity) {
		return template.insert("executeParamDao.addToTemp", entity) > 0;
	}

	public boolean updateToTemp(ExecuteParamEntity entity) {
		return template.update("executeParamDao.updateToTemp", entity) > 0;
	}

	public boolean deleteFromTemp(ExecuteParamEntity entity) {
		return template.delete("executeParamDao.deleteFromTemp", entity.getId()) > 0;
	}

	public ExecuteParamEntity findFromTempById(int id) {
		// TODO Auto-generated method stub
		return template.selectOne("executeParamDao.findFromTempById", id);
	}

	public boolean deleteFromTempByExecute(Integer executeId) {
		return template.delete("executeParamDao.deleteFromTempByExecute", executeId) > 0;
	}

	public List<ExecuteParamEntity> findFromTempByBlocks(List<Integer> blocks) {
		StringBuilder sb = new StringBuilder();
		for (Integer be : blocks) {
			sb.append(be + ",");
		}
		sb.setLength(sb.length() - 1);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("blocks", sb.toString());
		return template.selectList("executeParamDao.findFromTempByBlocks", map);
	}

	public List<ExecuteParamEntity> findFromTempByExecute(Integer execute) {
		// TODO Auto-generated method stub
		return template.selectList("executeParamDao.findFromTempByExecute", execute);
	}

	public List<ExecuteParamEntity> findFromTempByProcess(Integer processId) {
		// TODO Auto-generated method stub
		return template.selectList("executeParamDao.findFromTempByProcess", processId);
	}

}
