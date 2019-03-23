package com.lin.request.resp;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.lin.entity.ExecuteParamEntity;
import com.lin.entity.PluginEntity;
import com.lin.entity.PluginMethodEntity;
import com.lin.request.CommonResp;

public class GetExecuteParamsResp extends CommonResp {

	private Integer type;
	private JSONObject params;
	private List<ExecuteParamEntity> executeParams;
	private PluginMethodEntity method;
	private PluginEntity plugin;

	public PluginMethodEntity getMethod() {
		return method;
	}

	public void setMethod(PluginMethodEntity method) {
		this.method = method;
	}

	public PluginEntity getPlugin() {
		return plugin;
	}

	public void setPlugin(PluginEntity plugin) {
		this.plugin = plugin;
	}

	public List<ExecuteParamEntity> getExecuteParams() {
		return executeParams;
	}

	public void setExecuteParams(List<ExecuteParamEntity> executeParams) {
		this.executeParams = executeParams;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public JSONObject getParams() {
		return params;
	}

	public void setParams(JSONObject params) {
		this.params = params;
	}

}
