package com.lin.dao;

import org.springframework.stereotype.Repository;

import com.lin.entity.ParamEntity;

@Repository
public class ParamDao extends BaseDao {
	public boolean addToTemp(ParamEntity entity) {
		return template.insert("paramDao.addToTemp", entity) > 0;
	}

	public boolean updateToTemp(ParamEntity entity) {
		return template.update("paramDao.updateToTemp", entity) > 0;
	}

	public boolean deleteFromTemp(ParamEntity entity) {
		return template.delete("paramDao.deleteFromTemp", entity.getId()) > 0;
	}

	public ParamEntity findFromTempById(int id) {
		// TODO Auto-generated method stub
		return template.selectOne("paramDao.findFromTempById", id);
	}

}
