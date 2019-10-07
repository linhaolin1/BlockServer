package com.lin.process.req;

import java.util.HashMap;

import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class ProcessReq {

	@PluginMethodVariableParamAnnotation()
	HashMap map;

	public HashMap getMap() {
		return map;
	}

	public void setMap(HashMap map) {
		this.map = map;
	}
}
