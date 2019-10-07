package com.lin.process.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class SendSmsResp {
	@PlguinMethodOutputParamAnnotation(displayName = "调用结果")
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
