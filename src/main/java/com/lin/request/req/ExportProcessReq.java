package com.lin.request.req;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class ExportProcessReq extends Propertyable {
	@KvField
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
