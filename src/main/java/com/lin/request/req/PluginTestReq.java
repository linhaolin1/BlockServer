package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class PluginTestReq extends Propertyable {
	Integer method;

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

}
