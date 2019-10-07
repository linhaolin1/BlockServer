package com.lin.wechat.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class JsApiReq {
	@PluginMethodParamAnnotation(displayName = "token")
	String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
