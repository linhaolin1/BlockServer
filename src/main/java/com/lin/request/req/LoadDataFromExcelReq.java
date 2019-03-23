package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class LoadDataFromExcelReq extends Propertyable {
	String excelPath;
	String groupName;

	String tableName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getExcelPath() {
		return excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

}
