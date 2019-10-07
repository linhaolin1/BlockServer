package com.lin.process.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class RedisGetResp {
	@PlguinMethodOutputParamAnnotation(displayName= "结果")
	String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
