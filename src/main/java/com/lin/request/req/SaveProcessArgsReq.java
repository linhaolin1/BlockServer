package com.lin.request.req;

import java.util.List;

import com.lin.nettyserver.http.bean.Propertyable;

public class SaveProcessArgsReq extends Propertyable {
	Integer process;
	String name;
	Integer isNecessary;
	Integer isComplex;
	Integer isMutitype;
	String belong;
	List<String> columns;
	
	public Integer getProcess() {
		return process;
	}
	public void setProcess(Integer process) {
		this.process = process;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIsNecessary() {
		return isNecessary;
	}
	public void setIsNecessary(Integer isNecessary) {
		this.isNecessary = isNecessary;
	}
	public Integer getIsComplex() {
		return isComplex;
	}
	public void setIsComplex(Integer isComplex) {
		this.isComplex = isComplex;
	}
	public Integer getIsMutitype() {
		return isMutitype;
	}
	public void setIsMutitype(Integer isMutitype) {
		this.isMutitype = isMutitype;
	}
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	
}
