package com.lin.database.req;

import java.util.Map;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class ComplexJoinQueryReq {
	@PluginMethodParamAnnotation(displayName = "sql")
	String sql;

	@PluginMethodParamAnnotation(displayName = "设置数量")
	String count;

	@PluginMethodVariableParamAnnotation()
	Map keyMap;

	@PluginMethodVariableParamAnnotation()
	Map valueMap;
	
	@PluginMethodParamAnnotation(displayName = "查询数量")
	String limitRow;

	@PluginMethodParamAnnotation(displayName = "页数")
	String page;

	@PluginMethodParamAnnotation(displayName = "排序")
	String order;


	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Map getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(Map keyMap) {
		this.keyMap = keyMap;
	}

	public Map getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map valueMap) {
		this.valueMap = valueMap;
	}

	public String getLimitRow() {
		return limitRow;
	}

	public void setLimitRow(String limitRow) {
		this.limitRow = limitRow;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}


}
