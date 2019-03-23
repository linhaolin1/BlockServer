package com.lin.request.resp;

import java.util.List;

import com.lin.entity.ProcessEntity;
import com.lin.request.CommonResp;

public class GetProcessListResp extends CommonResp {

	List<ProcessEntity> processes;

	public List<ProcessEntity> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessEntity> processes) {
		this.processes = processes;
	}

}
