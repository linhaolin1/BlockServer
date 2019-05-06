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
import com.lin.request.req.DelExecuteReq;
import com.lin.request.req.GetExecuteParamsReq;
import com.lin.request.req.GetExecuteVariableParamsReq;
import com.lin.request.req.SaveExecuteParamReq;
import com.lin.request.req.SaveExecuteReq;
import com.lin.request.resp.DelExecuteResp;
import com.lin.request.resp.GetExecuteParamsResp;
import com.lin.request.resp.GetExecuteVariableParamsResp;
import com.lin.request.resp.SaveExecuteParamResp;
import com.lin.request.resp.SaveExecuteResp;
import com.lin.service.ExecuteService;
import com.lin.service.PluginService;

@HttpHandler
@Component
public class ExecuteAction {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExecuteService executeService;

	@Autowired
	PluginService pluginService;

	@Subscribe
	@RequestMapper(url = "/block-server/saveExecuteParam", codecName = "blockJsonDecodec", clazz = SaveExecuteParamReq.class)
	public void saveExecuteParam(SaveExecuteParamReq req) {
		logger.debug("SaveExecuteReq:{}", req);
		SaveExecuteParamResp resp = new SaveExecuteParamResp();
		try {
			executeService.saveExecuteParam(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/saveExecute", codecName = "blockKvDecodec", clazz = SaveExecuteReq.class)
	public void saveExecute(SaveExecuteReq req) {
		logger.debug("SaveExecuteReq:{}", req);
		SaveExecuteResp resp = new SaveExecuteResp();
		try {
			executeService.saveExecute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/getExecuteParams", codecName = "blockKvDecodec", clazz = GetExecuteParamsReq.class)
	public void getExecuteParams(GetExecuteParamsReq req) {
		logger.debug("GetPluginMethodParamsReq:{}", req);
		GetExecuteParamsResp resp = new GetExecuteParamsResp();
		try {
			executeService.getExecuteParams(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/getExecuteVariableParams", codecName = "blockJsonDecodec", clazz = GetExecuteVariableParamsReq.class)
	public void getExecuteVariableParams(GetExecuteVariableParamsReq req) {
		logger.debug("GetExecuteVariableParamsReq:{}", req);
		GetExecuteVariableParamsResp resp = new GetExecuteVariableParamsResp();
		try {
			executeService.getExecuteVariableParams(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/deleteExecute", codecName = "blockJsonDecodec", clazz = DelExecuteReq.class)
	public void deleteExecute(DelExecuteReq req) {
		logger.debug("DelExecuteReq:{}", req);
		DelExecuteResp resp = new DelExecuteResp();
		try {
			executeService.deleteExecute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

}
