package com.lin.entity;

public class ParamEntity extends AbstractEntity {
	private String paramValue;
	private String belong; // request:请求内容 data:数据库内容 trans:转换内容 outer:外部请求回复

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

}