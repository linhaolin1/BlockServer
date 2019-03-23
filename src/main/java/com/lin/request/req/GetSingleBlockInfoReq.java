package com.lin.request.req;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class GetSingleBlockInfoReq extends Propertyable {
	@KvField()
	private Integer blockId;

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

}
