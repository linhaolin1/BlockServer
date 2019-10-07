package com.lin.database.resp;

import java.util.Map;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class SelectOneResp {
	@PlguinMethodOutputParamAnnotation(displayName= "结果")
	Map<String, Object> object;

	public Map<String, Object> getObject() {
		return object;
	}

	public void setObject(Map<String, Object> object) {
		this.object = object;
	}
	
}
