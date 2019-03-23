package com.lin.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.PluginEntity;

@Repository
public class PluginDao extends BaseDao {

	public boolean insert(PluginEntity entity) {
		return template.insert("pluginDao.add", entity) > 0;
	}

	public boolean update(PluginEntity entity) {
		return template.update("pluginDao.update", entity) > 0;
	}

	public boolean delete(PluginEntity entity) {
		return template.delete("pluginDao.delete", entity.getId()) > 0;
	}

	public PluginEntity findById(int id) {
		// TODO Auto-generated method stub
		return template.selectOne("pluginDao.findById", id);
	}

	public PluginEntity findByClass(String className) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("className", className);
		return template.selectOne("pluginDao.findByClass", map);
	}

	public List<PluginEntity> findByAvailPlugins() {
		// TODO Auto-generated method stub
		return template.selectList("pluginDao.findAll");
	}

	public List<PluginEntity> findPlugins(String filterName, Integer pluginType) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("filterName", filterName);
		map.put("pluginType", pluginType);
		return template.selectList("pluginDao.findPlugins", map);
	}
}
