package com.lin.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.Subscribe;
import com.lin.constants.Result;
import com.lin.nettyserver.http.annotation.HttpHandler;
import com.lin.nettyserver.http.annotation.RequestMapper;
import com.lin.nettyserver.http.util.ResponseUtil;
import com.lin.request.req.GetAvailablePluginsReq;
import com.lin.request.req.GetPluginMethodReq;
import com.lin.request.req.GetPluginsReq;
import com.lin.request.resp.GetAvailablePluginsResp;
import com.lin.request.resp.GetPluginMethodResp;
import com.lin.request.resp.GetPluginsResp;
import com.lin.service.PluginService;

@HttpHandler
@Component
public class PluginAction {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PluginService pluginService;

	@Subscribe
	@RequestMapper(url = "/block-server/getPlugins", codecName = "blockKvDecodec", clazz = GetPluginsReq.class)
	public void getPlugins(GetPluginsReq req) {
		logger.debug("GetPluginsReq:{}", req);
		GetPluginsResp resp = new GetPluginsResp();
		try {
			pluginService.getPlugins(req, resp);
		} catch (Exception e) {
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp).toString());
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/getPluginMethods", codecName = "blockKvDecodec", clazz = GetPluginMethodReq.class)
	public void getPluginMethods(GetPluginMethodReq req) {
		logger.debug("GetPluginMethodReq:{}", req);
		GetPluginMethodResp resp = new GetPluginMethodResp();
		try {
			pluginService.getPluginMethods(req, resp);
		} catch (Exception e) {
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp).toString());
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/getAvailablePlugins", codecName = "blockKvDecodec", clazz = GetAvailablePluginsReq.class)
	public void getAvailablePlugins(GetAvailablePluginsReq req) {
		logger.debug("GetAvailablePluginsReq:{}", req);
		GetAvailablePluginsResp resp = new GetAvailablePluginsResp();
		try {
			pluginService.getAvailablePlugins(req, resp);
		} catch (Exception e) {
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

}
