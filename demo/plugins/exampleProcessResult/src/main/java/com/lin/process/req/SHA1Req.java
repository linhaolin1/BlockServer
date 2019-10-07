package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class SHA1Req {
	@PluginMethodParamAnnotation(displayName = "内容")
	String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
