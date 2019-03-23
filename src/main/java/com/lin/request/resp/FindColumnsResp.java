package com.lin.request.resp;

import java.util.List;

import com.lin.request.CommonResp;

public class FindColumnsResp extends CommonResp {
	List<String> columns;

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	
}
