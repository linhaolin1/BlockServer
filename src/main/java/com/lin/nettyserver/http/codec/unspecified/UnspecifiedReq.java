package com.lin.nettyserver.http.codec.unspecified;

import java.util.Map;

import com.lin.nettyserver.http.bean.Propertyable;

public class UnspecifiedReq extends Propertyable {
	Map<String, Object> object;
	String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> getObject() {
		return object;
	}

	public void setObject(Map object) {
		this.object = object;
	}

}
