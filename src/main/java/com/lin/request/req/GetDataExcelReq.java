package com.lin.request.req;

import java.util.List;
import java.util.Map;

import com.lin.nettyserver.http.bean.Propertyable;

public class GetDataExcelReq extends Propertyable {
	String tableName;

	Map<String, List> param;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, List> getParam() {
		return param;
	}

	public void setParam(Map<String, List> param) {
		this.param = param;
	}

}
