package com.lin.process.resp;

import java.util.Map;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputVariableParamAnnotation;

public class ProcessResp {

	@PlguinMethodOutputVariableParamAnnotation()
	Map outMap;

	public Map getOutMap() {
		return outMap;
	}

	public void setOutMap(Map outMap) {
		this.outMap = outMap;
	}

}
