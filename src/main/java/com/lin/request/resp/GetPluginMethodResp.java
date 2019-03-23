package com.lin.request.resp;

import java.util.List;

import com.lin.entity.PluginMethodEntity;
import com.lin.request.CommonResp;

public class GetPluginMethodResp extends CommonResp {
	private List<PluginMethodEntity> methods;

	public List<PluginMethodEntity> getMethods() {
		return methods;
	}

	public void setMethods(List<PluginMethodEntity> methods) {
		this.methods = methods;
	}

}
