package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class FindColumnsReq extends Propertyable {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
