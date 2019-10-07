package com.lin.wechat.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class AccessTokenResp {
	@PlguinMethodOutputParamAnnotation(displayName="token")
	String token;
	@PlguinMethodOutputParamAnnotation(displayName="结果")
	String result;
	@PlguinMethodOutputParamAnnotation(displayName="申请时间")
	String time;
	@PlguinMethodOutputParamAnnotation(displayName="有效时间")
	String expire;
	
	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
