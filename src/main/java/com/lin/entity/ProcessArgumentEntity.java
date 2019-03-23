package com.lin.entity;

public class ProcessArgumentEntity extends AbstractEntity {
	private String name;
	private Integer type = 0; // 0:输入 1：输出
	private Integer process = 0;
	private Integer necessary = 0; // 0:必须 1：非必须
	private Integer complex = 0;
	private Integer mutitype = 0; // 0:单个 1：多个

	public Integer getComplex() {
		return complex;
	}

	public void setComplex(Integer complex) {
		this.complex = complex;
	}

	public Integer getMutitype() {
		return mutitype;
	}

	public void setMutitype(Integer mutitype) {
		this.mutitype = mutitype;
	}

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNecessary() {
		return necessary;
	}

	public void setNecessary(Integer necessary) {
		this.necessary = necessary;
	}

}
