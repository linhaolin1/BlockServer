package com.lin.request.req;

import java.util.Map;

import com.lin.nettyserver.http.bean.Propertyable;

public class AddTableDataReq extends Propertyable {
	String tableName;
	Map<String, String> obj;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Map<String, String> getObj() {
		return obj;
	}
	public void setObj(Map<String, String> obj) {
		this.obj = obj;
	}
	
}
