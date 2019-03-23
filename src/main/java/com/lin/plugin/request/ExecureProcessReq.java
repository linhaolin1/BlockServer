package com.lin.plugin.request;

import java.util.HashMap;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class ExecureProcessReq {
	@PluginMethodParamAnnotation(displayName = "流程ID")
	String processId;

	@PluginMethodVariableParamAnnotation()
	HashMap map;

	public HashMap getMap() {
		return map;
	}

	public void setMap(HashMap map) {
		this.map = map;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

}
