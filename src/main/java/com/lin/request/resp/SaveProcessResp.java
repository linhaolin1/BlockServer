package com.lin.request.resp;

import com.lin.entity.ProcessEntity;
import com.lin.request.CommonResp;

public class SaveProcessResp extends CommonResp {
	ProcessEntity process;

	public ProcessEntity getProcess() {
		return process;
	}

	public void setProcess(ProcessEntity process) {
		this.process = process;
	}

}
