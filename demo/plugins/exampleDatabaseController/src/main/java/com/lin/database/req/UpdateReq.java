package com.lin.database.req;

import java.util.Map;

import com.lin.interfacePackage.Annotation.DatabaseTableAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class UpdateReq {
	@DatabaseTableAnnotation(displayName = "表名")
	String tableName;

	@PluginMethodVariableParamAnnotation
	Map map;

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

}
