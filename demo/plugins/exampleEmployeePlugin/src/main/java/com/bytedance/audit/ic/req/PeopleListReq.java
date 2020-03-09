package com.bytedance.audit.ic.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class PeopleListReq {
	@PluginMethodParamAnnotation(displayName = "appid", fieldName = "")
	private String appid;
	@PluginMethodParamAnnotation(displayName = "secret", fieldName = "")
	private String secret;
	@PluginMethodParamAnnotation(displayName = "url", fieldName = "")
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
