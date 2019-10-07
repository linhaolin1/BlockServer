package com.lin.process.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class TransferResp {
	@PlguinMethodOutputParamAnnotation(displayName = "结果")
	String result;
	@PlguinMethodOutputParamAnnotation(displayName = "原因")
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
