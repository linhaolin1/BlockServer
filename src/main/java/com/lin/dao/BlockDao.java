package com.lin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.BlockEntity;

@Repository
public class BlockDao extends BaseDao {

	public List<BlockEntity> findFromTempByProcess(int process) {
		return template.selectList("blockDao.findFromTempByProcess", process);
	}

	public boolean addToTemp(BlockEntity entity) {
		return template.insert("blockDao.addToTemp", entity) > 0;
	}

	public boolean updateToTemp(BlockEntity entity) {
		return template.update("blockDao.updateToTemp", entity) > 0;
	}

	public boolean deleteFromTemp(BlockEntity entity) {
		return template.delete("blockDao.deleteFromTemp", entity.getId()) > 0;
	}

	public BlockEntity findFromTempById(Integer blockId) {
		// TODO Auto-generated method stub
		return template.selectOne("blockDao.findFromTempById", blockId);
	}
}
