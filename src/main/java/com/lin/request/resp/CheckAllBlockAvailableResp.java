package com.lin.request.resp;

import java.util.List;

import com.lin.entity.BlockEntity;
import com.lin.request.CommonResp;

public class CheckAllBlockAvailableResp extends CommonResp {
	List<BlockEntity> array;

	public List<BlockEntity> getArray() {
		return array;
	}

	public void setArray(List<BlockEntity> array) {
		this.array = array;
	}

}
