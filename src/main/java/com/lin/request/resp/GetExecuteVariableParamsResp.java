package com.lin.request.resp;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.lin.entity.ExecuteParamEntity;
import com.lin.entity.PluginMethodParamEntity;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotationClass;
import com.lin.request.CommonResp;

public class GetExecuteVariableParamsResp extends CommonResp {
	List<PluginMethodParamAnnotationClass> inArgs;

	List<PluginMethodParamAnnotationClass> outArgs;

	private List<ExecuteParamEntity> executeParams;

	public List<ExecuteParamEntity> getExecuteParams() {
		return executeParams;
	}

	public void setExecuteParams(List<ExecuteParamEntity> executeParams) {
		this.executeParams = executeParams;
	}

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