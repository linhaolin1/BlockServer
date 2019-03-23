package com.lin.entity;

public class ExecuteParamEntity extends AbstractEntity {
	private Integer execute = 0;
	private String fieldName;
	private String pluginMethodParam;
	private String param;
	private Integer type = 0; // 0:输入参数 1：输出参数

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getExecute() {
		return execute;
	}

	public void setExecute(Integer execute) {
		this.execute = execute;
	}

	public String getPluginMethodParam() {
		return pluginMethodParam;
	}

	public void setPluginMethodParam(String pluginMethodParam) {
		this.pluginMethodParam = pluginMethodParam;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
