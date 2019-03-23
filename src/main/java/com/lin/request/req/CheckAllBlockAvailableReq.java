package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class CheckAllBlockAvailableReq extends Propertyable {
	Integer processId;

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
}
