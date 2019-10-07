package com.lin.process.req;

import java.util.HashMap;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class Process2Req {
	
	@PluginMethodParamAnnotation(displayName="设置数量")
	String count;
	
	
	@PluginMethodVariableParamAnnotation()
	HashMap<String,Object> map;

	public HashMap<String,Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String,Object> map) {
		this.map = map;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
}
