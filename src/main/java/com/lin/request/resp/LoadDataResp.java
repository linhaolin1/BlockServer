package com.lin.request.resp;

import java.util.List;
import java.util.Map;

import com.lin.request.CommonResp;

public class LoadDataResp extends CommonResp {
	List<Map<String, Object>> datas;
	List<String> columns;
	public List<Map<String, Object>> getDatas() {
		return datas;
	}
	public void setDatas(List<Map<String, Object>> datas) {
		this.datas = datas;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

}
