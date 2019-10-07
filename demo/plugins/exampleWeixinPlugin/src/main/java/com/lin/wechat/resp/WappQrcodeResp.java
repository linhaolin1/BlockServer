package com.lin.wechat.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class WappQrcodeResp {
	@PlguinMethodOutputParamAnnotation(displayName="status")
	String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
