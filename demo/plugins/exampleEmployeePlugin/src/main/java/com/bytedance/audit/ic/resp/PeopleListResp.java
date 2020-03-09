package com.bytedance.audit.ic.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

import java.util.List;

public class PeopleListResp {
	@PlguinMethodOutputParamAnnotation(displayName= "结果")
	List result;

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}
	
}
