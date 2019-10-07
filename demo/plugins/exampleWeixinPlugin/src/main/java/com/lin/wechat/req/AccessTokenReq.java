package com.lin.wechat.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class AccessTokenReq {
	@PluginMethodParamAnnotation(displayName = "appid")
	String appid;
	@PluginMethodParamAnnotation(displayName = "appsecret")
	String appSecret;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

}
