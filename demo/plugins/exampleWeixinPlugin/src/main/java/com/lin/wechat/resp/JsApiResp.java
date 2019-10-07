package com.lin.wechat.resp;

import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;

public class JsApiResp {
	@PlguinMethodOutputParamAnnotation(displayName="ticket")
	String ticket;
	@PlguinMethodOutputParamAnnotation(displayName="结果")
	String result;
	@PlguinMethodOutputParamAnnotation(displayName="申请时间")
	String time;
	@PlguinMethodOutputParamAnnotation(displayName="有效时间")
	String expire;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

}
