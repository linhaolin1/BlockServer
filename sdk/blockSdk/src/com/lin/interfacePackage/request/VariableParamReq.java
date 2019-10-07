package com.lin.interfacePackage.request;

import java.util.Map;

public class VariableParamReq {
	String methodName;
	Map<String, String> map;
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
}
