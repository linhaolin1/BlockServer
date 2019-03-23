package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class GetModelExcelReq extends Propertyable {
	String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
