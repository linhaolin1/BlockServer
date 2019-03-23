package com.lin.request.resp;

import java.util.List;

import com.lin.entity.PluginMethodParamEntity;
import com.lin.request.CommonResp;

public class GetPluginVariableParamsResp extends CommonResp {
	List<PluginMethodParamEntity> list;

	public List<PluginMethodParamEntity> getList() {
		return list;
	}

	public void setList(List<PluginMethodParamEntity> list) {
		this.list = list;
	}

}