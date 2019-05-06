package com.lin.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lin.entity.DataTableEntity;

@Repository
public class DataTableDao extends BaseDao {

	public void addNewTable(Integer id, String name, List<String> list) {
		if (id == null) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("tableName", name);
			map.put("columns", list);
			businessTemplate.insert("dataTableDao.addNewTable", map);

			DataTableEntity dt = new DataTableEntity();
			dt.setName(name);
			template.insert("dataTableDao.add", dt);

		} else {
			
			List<String> existColumns=findColumns(name);
			list.removeAll(existColumns);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("tableName", name);
			map.put("columns", list);
			businessTemplate.insert("dataTableDao.addNewColumns", map);

		}
	}

	public void updateTable() {

	}

	public List<DataTableEntity> getAvailableDataTable() {
		return template.selectList("dataTableDao.findAll");
	}

	public List<String> findColumns(String name) {
		// TODO Auto-generated method stub
		Map<String, String> queryMap = new HashMap();
		queryMap.put("name", name);
		List<Map<String, Object>> map = businessTemplate.selectList("dataTableDao.findColumns", queryMap);
		List<String> list = new ArrayList<String>();
		for (Map<String, Object> m : map) {
			list.add((String) m.get("Field"));
		}
		return list;
	}

	public List<Map<String, Object>> findData(String tableName, Integer page, Integer pageSize,
			Map<String, List> query) {
		// TODO Auto-generated method stub
		Map<String, Object> queryMap = new HashMap();
		queryMap.put("tableName", tableName);
		queryMap.put("offset", (page - 1) * pageSize);
		queryMap.put("pageSize", pageSize);
		queryMap.put("query", query);

		return businessTemplate.selectList("dataTableDao.findData", queryMap);
	}

	public Integer addTableData(String tableName, Map<String, String> properties) {
		// TODO Auto-generated method stub
		Map<String, Object> queryMap = new HashMap();
		queryMap.put("properties", properties);
		queryMap.put("tableName", tableName);
		businessTemplate.insert("dataTableDao.addTableData", queryMap);
		return (Integer) queryMap.get("id");
	}

	public void updateTableData(String tableName, Map<String, String> transferMap) {
		// TODO Auto-generated method stub
		Map<String, Object> queryMap = new HashMap();
		queryMap.put("properties", transferMap);
		queryMap.put("tableName", tableName);
		businessTemplate.insert("dataTableDao.updateTableData", queryMap);
	}

	public void deleteTableData(String tableName, Map<String, String> transferMap) {
		// TODO Auto-generated method stub
		Map<String, Object> queryMap = new HashMap();
		queryMap.put("properties", transferMap);
		queryMap.put("tableName", tableName);
		businessTemplate.insert("dataTableDao.deleteTableData", queryMap);
	}
}
