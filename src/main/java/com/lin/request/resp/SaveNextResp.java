package com.lin.request.resp;

import com.lin.entity.NextEntity;
import com.lin.request.CommonResp;

public class SaveNextResp extends CommonResp {
	NextEntity next;

	public NextEntity getNext() {
		return next;
	}

	public void setNext(NextEntity next) {
		this.next = next;
	}

}
