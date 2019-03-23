package com.lin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.ProcessEntity;

@Repository
public class ProcessDao extends BaseDao {

	public boolean addToTemp(ProcessEntity entity) {
		return template.insert("processDao.addToTemp", entity) > 0;
	}

	public boolean updateToTemp(ProcessEntity entity) {
		return template.update("processDao.updateToTemp", entity) > 0;
	}

	public boolean deleteFromTemp(Integer id) {
		return template.delete("processDao.deleteFromTemp", id) > 0;
	}

	public ProcessEntity findFromTempById(Integer processId) {
		// TODO Auto-generated method stub
		return template.selectOne("processDao.findFromTempById", processId);
	}

	public void copyProcessFromMainToTemp(Integer processId) {
		template.insert("processDao.copyProcessFromMainToTemp", processId);
	}

	public void copyProcessFromTempToMain(Integer processId) {
		template.insert("processDao.copyProcessFromTempToMain", processId);
	}

	public void test() {

	}

	public List<ProcessEntity> findAll() {
		// TODO Auto-generated method stub
		return template.selectList("processDao.findAll");
	}
}
