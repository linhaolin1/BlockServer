package com.lin.dao;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.entity.TestResultEntity;

@Repository
public class TestResultDao extends BaseDao {

	public void save(TestResultEntity result) {
		// TODO Auto-generated method stub

	}

	public List<TestResultEntity> findTestRecord(int plugin, Method method) {
		// TODO Auto-generated method stub
		return null;
	}

}
