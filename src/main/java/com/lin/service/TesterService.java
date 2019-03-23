package com.lin.service;

import com.lin.request.req.PluginTestReq;
import com.lin.request.req.ProcessTestReq;
import com.lin.request.resp.PluginTestResp;
import com.lin.request.resp.ProcessTestResp;

public interface TesterService {
	public void testPlugin(PluginTestReq req,PluginTestResp resp);
	
	public void testProcess(ProcessTestReq req,ProcessTestResp resp);
	
}
