package com.lin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lin.entity.DynamicRequestEntity;

@Repository
public class DynamicRequestDao extends BaseDao {
	public DynamicRequestEntity findByUrl(String url) {
		Map<String, Object> queryMap = new HashMap();
		queryMap.put("url", url);
		return template.selectOne("dynamicRequestDao.findByUrl", queryMap);
	}

	public void addNewDynamicRequest(String url, Integer processId) {
		Map<String, Object> map = new HashMap();
		map.put("url", url);
		map.put("processId", processId);
		template.insert("dynamicRequestDao.addNewDynamicRequest", map);
	}

	public void deleteByProcess(Integer processId) {
		Map<String, Object> map = new HashMap();
		map.put("processId", processId);
		template.delete("dynamicRequestDao.deleteByProcess", map);
	}
	
	public List<DynamicRequestEntity> findAll(){
		return template.selectList("dynamicRequestDao.findAll");
	}

}
