package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class MD5Req {
	@PluginMethodParamAnnotation(displayName = "MD5", fieldName = "")
	String param;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
