package com.lin.dao;

import org.springframework.stereotype.Repository;

import com.lin.entity.DataSourceEntity;

@Repository
public class DataSourceDao extends BaseDao {

	public DataSourceEntity findById(int id) {
		return template.selectOne("dataSourceDao.findById", id);
	}

	public boolean insert(DataSourceEntity entity) {
		return template.insert("dataSourceDao.insert", entity) > 0;
	}

	public boolean update(DataSourceEntity entity) {
		return template.update("dataSourceDao.update", entity) > 0;
	}

	public boolean delete(DataSourceEntity entity) {
		return template.delete("dataSourceDao.delete", entity) > 0;
	}

	public void test() {

	}
}
