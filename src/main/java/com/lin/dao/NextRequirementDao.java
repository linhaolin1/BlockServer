package com.lin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lin.entity.NextRequirementEntity;

@Repository
public class NextRequirementDao extends BaseDao {
	public List<NextRequirementEntity> findFromTempByNext(int next) {
		return template.selectList("nextRequirementDao.findFromTempByNext", next);
	}

	public boolean addToTemp(NextRequirementEntity entity) {
		return template.insert("nextRequirementDao.addToTemp", entity) > 0;
	}

	public boolean updateToTemp(NextRequirementEntity entity) {
		return template.update("nextRequirementDao.updateToTemp", entity) > 0;
	}

	public boolean deleteFromTemp(NextRequirementEntity entity) {
		return template.delete("nextRequirementDao.deleteFromTemp", entity.getId()) > 0;
	}

	public NextRequirementEntity findFromTempById(int id) {
		// TODO Auto-generated method stub
		return template.selectOne("nextRequirementDao.findFromTempById", id);
	}

	public boolean deleteByNextFromTemp(Integer nextId) {
		// TODO Auto-generated method stub
		return template.delete("nextRequirementDao.deleteByNextFromTemp", nextId) > 0;
	}

	public boolean addToTemp(Map map) {
		// TODO Auto-generated method stub
		return template.insert("nextRequirementDao.addMapToTemp", map) > 0;
	}

}
