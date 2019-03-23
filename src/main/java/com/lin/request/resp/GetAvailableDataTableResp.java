package com.lin.request.resp;

import java.util.List;

import com.lin.entity.DataTableEntity;
import com.lin.request.CommonResp;

public class GetAvailableDataTableResp extends CommonResp {
	List<DataTableEntity> list;

	public List<DataTableEntity> getList() {
		return list;
	}

	public void setList(List<DataTableEntity> list) {
		this.list = list;
	}
	
}
