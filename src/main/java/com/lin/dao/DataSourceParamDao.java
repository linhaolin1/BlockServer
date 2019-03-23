package com.lin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.DataSourceParamEntity;

@Repository
public class DataSourceParamDao extends BaseDao {

	public List<DataSourceParamEntity> findByDataSource(int dataSource) {
		return template.selectList("dataSourceParamDao.findByDataSource", dataSource);
	}

	public boolean insert(DataSourceParamEntity entity) {
		return template.insert("dataSourceParamDao.add", entity) > 0;
	}

	public boolean update(DataSourceParamEntity entity) {
		return template.update("dataSourceParamDao.update", entity) > 0;
	}

	public boolean delete(DataSourceParamEntity entity) {
		return template.delete("dataSourceParamDao.delete", entity.getId()) > 0;
	}

	public DataSourceParamEntity findById(int id) {
		// TODO Auto-generated method stub
		return template.selectOne("dataSourceParamDao.findById", id);
	}

	public void test() {

	}

}
