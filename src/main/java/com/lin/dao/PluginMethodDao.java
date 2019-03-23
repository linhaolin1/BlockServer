package com.lin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.PluginMethodEntity;

@Repository
public class PluginMethodDao extends BaseDao {
	public List<PluginMethodEntity> findByPlugin(int plugin) {
		return template.selectList("pluginMethodDao.findByPlugin", plugin);
	}

	public boolean insert(PluginMethodEntity entity) {
		return template.insert("pluginMethodDao.add", entity) > 0;
	}

	public boolean update(PluginMethodEntity entity) {
		return template.update("pluginMethodDao.update", entity) > 0;
	}

	public boolean delete(PluginMethodEntity entity) {
		return template.delete("pluginMethodDao.delete", entity.getId()) > 0;
	}

	public PluginMethodEntity findById(Integer method) {
		// TODO Auto-generated method stub
		return template.selectOne("pluginMethodDao.findById", method);
	}

	public void test() {

	}

	public Integer findByPluginAndMethodName(PluginMethodEntity entity) {
		// TODO Auto-generated method stub
		return template.selectOne("pluginMethodDao.findByPluginAndMethodName", entity);
	}
}
