package com.lin.request.req;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class GetPluginsReq extends Propertyable {
	@KvField()
	int pluginType;
	@KvField()
	String filterName;

	public int getPluginType() {
		return pluginType;
	}

	public void setPluginType(int pluginType) {
		this.pluginType = pluginType;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
