package com.lin.request.resp;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.lin.request.CommonResp;

public class GetPluginsResp extends CommonResp {

	List<JSONObject> list;

	public List<JSONObject> getList() {
		return list;
	}

	public void setList(List<JSONObject> list) {
		// TODO Auto-generated method stub
		this.list = list;
	}

}
