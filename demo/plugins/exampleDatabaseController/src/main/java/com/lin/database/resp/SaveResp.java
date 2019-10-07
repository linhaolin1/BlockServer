package com.lin.database.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class SaveResp {
	@PlguinMethodOutputParamAnnotation(displayName= "resultid")
	String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
