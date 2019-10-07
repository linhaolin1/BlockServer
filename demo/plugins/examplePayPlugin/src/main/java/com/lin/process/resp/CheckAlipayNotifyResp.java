package com.lin.process.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class CheckAlipayNotifyResp {
	@PlguinMethodOutputParamAnnotation(displayName="验证结果")
	String isOk;

	public String getIsOk() {
		return isOk;
	}

	public void setIsOk(String isOk) {
		this.isOk = isOk;
	}
	
	
}
