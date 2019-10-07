package com.lin.database.req;

import java.util.HashMap;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class DirectSqlReq {
	@PluginMethodParamAnnotation(displayName = "sql")
	String sql;

	@PluginMethodParamAnnotation(displayName = "设置数量")
	String count;

	@PluginMethodParamAnnotation(displayName = "查询数量")
	String limitRow;

	@PluginMethodParamAnnotation(displayName = "页数")
	String page;

	@PluginMethodVariableParamAnnotation()
	HashMap<String, Object> map;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
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

}
