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
import com.lin.request.req.GetHTMLParamsReq;
import com.lin.request.resp.GetHTMLParamsResp;
import com.lin.service.HTMLService;

@HttpHandler
@Component
public class HTMLParamsContoller {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HTMLService htmlService;
	
	@Subscribe
	@RequestMapper(url = "/block-server/getHTMLParams", codecName = "blockKvDecodec", clazz = GetHTMLParamsReq.class)
	public void getHTMLParams(GetHTMLParamsReq req){
		logger.debug("GetHTMLParamsReq:{}", req);
		GetHTMLParamsResp resp = new GetHTMLParamsResp();
		try {
			htmlService.getHTMLParams(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}
}
