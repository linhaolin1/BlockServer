package com.lin.request.req;

import java.util.Map;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class GetExecuteParamsReq extends Propertyable {
	@KvField()
	private Integer executeId;
	@KvField()
	private Integer methodId;
	@KvField()
	private Map<String, Object> map;

	public Integer getExecuteId() {
		return executeId;
	}

	public void setExecuteId(Integer executeId) {
		this.executeId = executeId;
	}

	public Integer getMethodId() {
		return methodId;
	}

	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
