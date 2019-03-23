package com.lin.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lin.entity.ProcessArgumentEntity;

@Repository
public class ProcessArgumentDao extends BaseDao {

	public void addToTemp(ProcessArgumentEntity entity) {
		template.insert("processArgumentDao.addToTemp", entity);
	}

	public ProcessArgumentEntity findFromTempById(Integer id) {
		return template.selectOne("processArgumentDao.findFromTempById", id);
	}

	public List<ProcessArgumentEntity> findFromTempByProcess(Integer process) {
		return template.selectList("processArgumentDao.findFromTempByProcess", process);
	}

	public void updateToTemp(ProcessArgumentEntity entity) {
		template.update("processArgumentDao.updateToTemp", entity);
	}

	public void deleteFromTemp(Integer id) {
		template.delete("processArgumentDao.deleteFromTemp", id);
	}

	public void deleteNotExistArgs(Integer processId, List<ProcessArgumentEntity> inArgs,
			List<ProcessArgumentEntity> outArgs) {
		// TODO Auto-generated method stub
		List<Integer> idList = new ArrayList<Integer>();

		for (ProcessArgumentEntity args : inArgs) {
			if (args.getId() != null && args.getId() > 0)
				idList.add(args.getId());
		}

		for (ProcessArgumentEntity args : outArgs) {
			if (args.getId() != null && args.getId() > 0)
				idList.add(args.getId());
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("process", processId);
		map.put("ids", idList);
		template.delete("processArgumentDao.deleteNotExistArgs", map);

	}

}
