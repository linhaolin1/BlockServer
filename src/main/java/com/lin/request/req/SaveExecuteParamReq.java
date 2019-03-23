package com.lin.request.req;

import com.alibaba.fastjson.JSONArray;
import com.lin.nettyserver.http.bean.Propertyable;

public class SaveExecuteParamReq extends Propertyable {
	JSONArray params;
	Integer executeId;

	public JSONArray getParams() {
		return params;
	}

	public void setParams(JSONArray params) {
		this.params = params;
	}

	public Integer getExecuteId() {
		return executeId;
	}

	public void setExecuteId(Integer executeId) {
		this.executeId = executeId;
	}

}
