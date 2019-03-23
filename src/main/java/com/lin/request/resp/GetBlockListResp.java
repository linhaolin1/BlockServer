package com.lin.request.resp;

import java.util.List;

import com.lin.entity.BlockEntity;
import com.lin.request.CommonResp;

public class GetBlockListResp extends CommonResp {
	private List<BlockEntity> list;

	public List<BlockEntity> getList() {
		return list;
	}

	public void setList(List<BlockEntity> list) {
		this.list = list;
	}

}
