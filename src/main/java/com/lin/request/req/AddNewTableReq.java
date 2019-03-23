package com.lin.request.req;

import java.util.List;

import com.lin.nettyserver.http.bean.Propertyable;

public class AddNewTableReq extends Propertyable {
	String tableName;
	List<String> columns;
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

}
