package com.lin.database.req;

import java.util.Map;

import com.lin.interfacePackage.Annotation.DatabaseTableAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class SelectReq {
	@DatabaseTableAnnotation(displayName = "表名")
	String tableName;

	@PluginMethodParamAnnotation(displayName = "查询数量")
	String limitRow;

	@PluginMethodParamAnnotation(displayName = "页数")
	String page;

	@PluginMethodParamAnnotation(displayName = "排序")
	String order;

	@PluginMethodVariableParamAnnotation
	Map map;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public String getLimitRow() {
		return limitRow;
	}

	public void setLimitRow(String limitRow) {
		this.limitRow = limitRow;
	}

}
