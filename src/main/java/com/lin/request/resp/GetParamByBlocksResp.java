package com.lin.request.resp;

import java.util.HashSet;

import com.lin.entity.ExecuteParamEntity;
import com.lin.request.CommonResp;

public class GetParamByBlocksResp extends CommonResp {
	HashSet<String> sets;

	public HashSet<String> getSets() {
		return sets;
	}

	public void setSets(HashSet<String> sets) {
		this.sets = sets;
	}

}
