package com.lin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.BlockDataSourceParamEntity;

@Repository
public class BlockDataSourceParamDao extends BaseDao {

	public List<BlockDataSourceParamEntity> findByBlock(int block) {
		return template.selectList("blockDataSourceParamDao.findByBlock", block);
	}

	public boolean insert(BlockDataSourceParamEntity entity) {
		return template.insert("blockDataSourceParamDao.add", entity) > 0;
	}

	public boolean update(BlockDataSourceParamEntity entity) {
		return template.update("blockDataSourceParamDao.update", entity) > 0;
	}

	public boolean delete(BlockDataSourceParamEntity entity) {
		return template.delete("blockDataSourceParamDao.delete", entity.getId()) > 0;
	}

	public void test() {

	}
}
