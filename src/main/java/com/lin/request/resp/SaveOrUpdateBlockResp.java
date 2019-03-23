package com.lin.request.resp;

import com.lin.entity.BlockEntity;
import com.lin.request.CommonResp;

public class SaveOrUpdateBlockResp extends CommonResp {
	BlockEntity block;

	public BlockEntity getBlock() {
		return block;
	}

	public void setBlock(BlockEntity block) {
		this.block = block;
	}
	
}
