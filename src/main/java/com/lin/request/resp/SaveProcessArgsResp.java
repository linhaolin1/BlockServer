package com.lin.request.resp;

import java.util.List;

import com.lin.entity.ProcessArgumentComplexEntity;
import com.lin.request.CommonResp;

public class SaveProcessArgsResp extends CommonResp {
	Integer id;
	List<ProcessArgumentComplexEntity> complex;
	
	public List<ProcessArgumentComplexEntity> getComplex() {
		return complex;
	}

	public void setComplex(List<ProcessArgumentComplexEntity> complex) {
		this.complex = complex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
