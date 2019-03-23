package com.lin.plugin.request;

import java.util.Map;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputVariableParamAnnotation;

public class ExecuteProcessResp {
	@PlguinMethodOutputVariableParamAnnotation()
	Map outMap;

	public Map getOutMap() {
		return outMap;
	}

	public void setOutMap(Map outMap) {
		this.outMap = outMap;
	}
}
