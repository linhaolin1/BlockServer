package com.lin.request.req;

import java.util.List;

import com.lin.nettyserver.http.bean.Propertyable;

public class GetParamByBlocksReq extends Propertyable {
	List<List<Integer>> blocks;
	Integer processId;

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public List<List<Integer>> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<List<Integer>> blocks) {
		this.blocks = blocks;
	}

}
