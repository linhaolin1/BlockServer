package com.lin.wechat.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class WebpageContentResp {
	@PlguinMethodOutputParamAnnotation(displayName = "pagetoken")
	String pageToken;
	@PlguinMethodOutputParamAnnotation(displayName = "expire")
	String expire;
	@PlguinMethodOutputParamAnnotation(displayName = "openid")
	String openid;

	public String getPageToken() {
		return pageToken;
	}

	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
