package com.lin.request.req;

import java.util.HashMap;
import java.util.Map;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class SaveExecuteReq extends Propertyable {
	@KvField()
	Integer blockId;
	@KvField()
	String executeName;
	@KvField()
	Integer methodId;

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public String getExecuteName() {
		return executeName;
	}

	public void setExecuteName(String executeName) {
		this.executeName = executeName;
	}

	public Integer getMethodId() {
		return methodId;
	}

	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}

}
