package com.lin.request.resp;

import java.util.List;

import com.lin.entity.BlockEntity;
import com.lin.entity.ExecuteEntity;
import com.lin.request.CommonResp;

public class GetSingleBlockInfoResp extends CommonResp {
	private BlockEntity block;
	private List<ExecuteEntity> executes;

	public BlockEntity getBlock() {
		return block;
	}

	public void setBlock(BlockEntity block) {
		this.block = block;
	}

	public List<ExecuteEntity> getExecutes() {
		return executes;
	}

	public void setExecutes(List<ExecuteEntity> executes) {
		this.executes = executes;
	}

}
