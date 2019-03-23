package com.lin.request.req;

import java.util.Map;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class SavePluginParamReq extends Propertyable {
	@KvField()
	private Integer pluginId;
	@KvField()
	private String methodName;
	@KvField()
	private Map<String, Object> map;

	public Integer getPluginId() {
		return pluginId;
	}

	public void setPluginId(Integer pluginId) {
		this.pluginId = pluginId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
