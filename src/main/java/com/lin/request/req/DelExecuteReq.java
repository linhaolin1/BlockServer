package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class DelExecuteReq extends Propertyable {
	Integer executeId;

	public Integer getExecuteId() {
		return executeId;
	}

	public void setExecuteId(Integer executeId) {
		this.executeId = executeId;
	}

}
