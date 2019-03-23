package com.lin.request.req;

import java.util.Map;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class ProcessReq extends Propertyable {
	@KvField()
	Map<String, Object> object;
	@KvField()
	Integer processId;

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public Map<String, Object> getObject() {
		return object;
	}

	public void setObject(Map<String, Object> object) {
		this.object = object;
	}

}
