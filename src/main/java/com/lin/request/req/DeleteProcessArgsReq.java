package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class DeleteProcessArgsReq extends Propertyable {
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
