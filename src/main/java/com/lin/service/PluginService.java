package com.lin.service;

import com.lin.request.req.GetAvailablePluginsReq;
import com.lin.request.req.GetPluginMethodReq;
import com.lin.request.req.GetPluginsReq;
import com.lin.request.resp.GetAvailablePluginsResp;
import com.lin.request.resp.GetPluginMethodResp;
import com.lin.request.resp.GetPluginsResp;

public interface PluginService {
	
	public void savePlugin(String fileName, String name, String introduce);

	public void savePlugin(byte[] fileByte, String name,String fileName ,String introduce);
	
	public void getPlugins(GetPluginsReq req, GetPluginsResp resp);

	public void getAvailablePlugins(GetAvailablePluginsReq req, GetAvailablePluginsResp resp);

	public void getPluginMethods(GetPluginMethodReq req, GetPluginMethodResp resp);

}
