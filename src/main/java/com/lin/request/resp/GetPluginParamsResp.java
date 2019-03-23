package com.lin.request.resp;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.request.CommonResp;

public class GetPluginParamsResp extends CommonResp {

	private Integer type;
	private PluginMethodParamAnnotation[] parms;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public PluginMethodParamAnnotation[] getParms() {
		return parms;
	}

	public void setParms(PluginMethodParamAnnotation[] parms) {
		this.parms = parms;
	}
}
