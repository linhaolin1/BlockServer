package com.lin.block;

import java.util.List;

public class ProcessArgument {
	private String name;
	private Integer type = 0; // 0:输入 1：输出
	private Integer necessary = 0; // 0:必须 1：非必须
	private Integer mutitype = 0; // 0:必须 1：非必须
	List<ProcessArgumentComplex> complex;

	public void setComplex(List<ProcessArgumentComplex> complex) {
		this.complex = complex;
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

	public List<ProcessArgumentComplex> getComplex() {
		return complex;
	}

	public Integer getMutitype() {
		return mutitype;
	}

	public void setMutitype(Integer mutitype) {
		this.mutitype = mutitype;
	}

}
