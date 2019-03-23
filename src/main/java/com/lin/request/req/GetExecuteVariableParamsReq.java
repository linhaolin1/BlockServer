package com.lin.request.req;

import java.util.Map;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class GetExecuteVariableParamsReq extends Propertyable {
	private Integer executeId;
	private Map<String, String> params;

	public Integer getExecuteId() {
		return executeId;
	}

	public void setExecuteId(Integer executeId) {
		this.executeId = executeId;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

}
