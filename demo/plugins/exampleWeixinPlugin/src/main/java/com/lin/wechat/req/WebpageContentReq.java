package com.lin.wechat.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class WebpageContentReq {
	
	@PluginMethodParamAnnotation(displayName = "code")
	String code;
	@PluginMethodParamAnnotation(displayName = "appid")
	String appid;
	@PluginMethodParamAnnotation(displayName = "secret")
	String secret;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
