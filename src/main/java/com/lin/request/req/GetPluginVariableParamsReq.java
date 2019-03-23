package com.lin.request.req;

import java.util.HashMap;
import java.util.Map;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class GetPluginVariableParamsReq extends Propertyable {
	@KvField()
	private Integer methodId;
	@KvField()
	private HashMap<String, String> params;

	public Integer getMethodId() {
		return methodId;
	}

	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

}
