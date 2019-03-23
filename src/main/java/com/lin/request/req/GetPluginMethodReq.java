package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class GetPluginMethodReq extends Propertyable {
	private Integer pluginId;

	public Integer getPluginId() {
		return pluginId;
	}

	public void setPluginId(Integer pluginId) {
		this.pluginId = pluginId;
	}

}
