package com.lin.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

public abstract class BaseDao {

	// @Autowired
	// SQLiteDataSource dataSource;
	//
	// public SQLiteDataSource getDataSource() {
	// return dataSource;
	// }
	//
	// public void setDataSource(SQLiteDataSource dataSource) {
	// this.dataSource = dataSource;
	// }

	@Qualifier("businessSqlSessionTemplate")
	@Autowired
	protected SqlSessionTemplate businessTemplate;

	@Qualifier("baseSqlSessionTemplate")
	@Autowired
	protected SqlSessionTemplate template;

	protected SqlSessionTemplate getTemplate() {
		return template;
	}

	protected void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

}
