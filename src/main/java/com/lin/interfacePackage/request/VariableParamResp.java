package com.lin.interfacePackage.request;

import java.util.List;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotationClass;

public class VariableParamResp {
	List<PluginMethodParamAnnotationClass> inArgs;

	List<PluginMethodParamAnnotationClass> outArgs;

	public List<PluginMethodParamAnnotationClass> getInArgs() {
		return inArgs;
	}

	public void setInArgs(List<PluginMethodParamAnnotationClass> inArgs) {
		this.inArgs = inArgs;
	} 

	public List<PluginMethodParamAnnotationClass> getOutArgs() {
		return outArgs;
	}

	public void setOutArgs(List<PluginMethodParamAnnotationClass> outArgs) {
		this.outArgs = outArgs;
	}
	
}
