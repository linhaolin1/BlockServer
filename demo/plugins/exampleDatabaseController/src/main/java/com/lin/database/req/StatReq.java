package com.lin.database.req;

import java.util.Map;

import com.lin.interfacePackage.Annotation.DatabaseTableAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class StatReq {

	@DatabaseTableAnnotation(displayName = "表名")
	String tableName;

	@PluginMethodParamAnnotation(displayName = "统计内容")
	String selectColumns;

	@PluginMethodParamAnnotation(displayName = "区分内容")
	String groupColumn;

	@PluginMethodParamAnnotation(displayName = "排序内容")
	String orderColumns;

	@PluginMethodParamAnnotation(displayName = "查询数量")
	String limitRow;

	@PluginMethodVariableParamAnnotation
	Map map;

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSelectColumns() {
		return selectColumns;
	}

	public void setSelectColumns(String selectColumns) {
		this.selectColumns = selectColumns;
	}

	public String getGroupColumn() {
		return groupColumn;
	}

	public void setGroupColumn(String groupColumn) {
		this.groupColumn = groupColumn;
	}

	public String getOrderColumns() {
		return orderColumns;
	}

	public void setOrderColumns(String orderColumns) {
		this.orderColumns = orderColumns;
	}

	public String getLimitRow() {
		return limitRow;
	}

	public void setLimitRow(String limitRow) {
		this.limitRow = limitRow;
	}

}
