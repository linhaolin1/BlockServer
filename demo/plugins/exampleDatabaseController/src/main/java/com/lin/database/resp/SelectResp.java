package com.lin.database.resp;

import java.util.List;
import java.util.Map;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class SelectResp {
	@PlguinMethodOutputParamAnnotation(displayName= "结果")
	List<Map<String, Object>> result;

	public List<Map<String, Object>> getResult() {
		return result;
	}

	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}

}
