package com.lin.request.req;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class DeleteNextReq extends Propertyable {
	@KvField
	Integer nextId;

	public Integer getNextId() {
		return nextId;
	}

	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}

}
