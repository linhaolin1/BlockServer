package com.lin.process.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class AlipayResp {
	@PlguinMethodOutputParamAnnotation(displayName="表单")
	String formString;

	public String getFormString() {
		return formString;
	}

	public void setFormString(String formString) {
		this.formString = formString;
	}

}
