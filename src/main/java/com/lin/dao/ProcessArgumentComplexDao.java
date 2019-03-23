package com.lin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.ProcessArgumentComplexEntity;

@Repository
public class ProcessArgumentComplexDao extends BaseDao {

	public void save(ProcessArgumentComplexEntity pace) {
		// TODO Auto-generated method stub
		template.insert("processArgumentComplexDao.save", pace);
	}

	public void deleteByArgument(Integer id) {
		// TODO Auto-generated method stub
		template.delete("processArgumentComplexDao.deleteByArgument",id);
	}

	public List<ProcessArgumentComplexEntity> findByProcess(Integer id) {
		// TODO Auto-generated method stub
		return template.selectList("processArgumentComplexDao.findByProcess",id);
	}
	
}
