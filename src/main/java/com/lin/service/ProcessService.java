package com.lin.service;

import java.util.Map;

import com.lin.request.req.CheckAllBlockAvailableReq;
import com.lin.request.req.CheckAllLineAvailableReq;
import com.lin.request.req.CheckAllParamAvailableReq;
import com.lin.request.req.DeleteProcessArgsReq;
import com.lin.request.req.DeleteProcessReq;
import com.lin.request.req.GetProcessListReq;
import com.lin.request.req.GetProcessReq;
import com.lin.request.req.ProcessReq;
import com.lin.request.req.SaveProcessArgsReq;
import com.lin.request.req.SaveProcessReq;
import com.lin.request.req.UpdateProcessReq;
import com.lin.request.resp.CheckAllBlockAvailableResp;
import com.lin.request.resp.CheckAllLineAvailableResp;
import com.lin.request.resp.CheckAllParamAvailableResp;
import com.lin.request.resp.DeleteProcessArgsResp;
import com.lin.request.resp.DeleteProcessResp;
import com.lin.request.resp.GetProcessListResp;
import com.lin.request.resp.GetProcessResp;
import com.lin.request.resp.ProcessResp;
import com.lin.request.resp.SaveProcessArgsResp;
import com.lin.request.resp.SaveProcessResp;
import com.lin.request.resp.UpdateProcessResp;

public interface ProcessService {
	public void executeProcess(ProcessReq req, ProcessResp resp);

	public void getProcess(GetProcessReq req, GetProcessResp resp);

	public void saveNewProcess(SaveProcessReq req, SaveProcessResp resp);

	public void deleteProcess(DeleteProcessReq req, DeleteProcessResp resp);

	public void updateProcess(UpdateProcessReq req, UpdateProcessResp resp);

	public void checkAllLineAvailable(CheckAllLineAvailableReq req, CheckAllLineAvailableResp resp);

	public void checkAllParamAvailable(CheckAllParamAvailableReq req, CheckAllParamAvailableResp resp);

	public void checkAllBlockAvailable(CheckAllBlockAvailableReq req, CheckAllBlockAvailableResp resp);

	public void getProcessList(GetProcessListReq req, GetProcessListResp resp);

	public void saveProcessArgs(SaveProcessArgsReq req, SaveProcessArgsResp resp);

	public void deleteProcessArgs(DeleteProcessArgsReq req, DeleteProcessArgsResp resp);

	public Integer getProcessByUrl(String url);
	
}
