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
import com.lin.request.req.DeleteNextReq;
import com.lin.request.req.GetParamByBlocksReq;
import com.lin.request.req.GetSingleBlockInfoReq;
import com.lin.request.req.RedirectNextReq;
import com.lin.request.req.SaveNextReq;
import com.lin.request.req.SaveOrUpdateBlockReq;
import com.lin.request.req.UpdateBlockPositionReq;
import com.lin.request.resp.DeleteNextResp;
import com.lin.request.resp.GetParamByBlocksResp;
import com.lin.request.resp.GetSingleBlockInfoResp;
import com.lin.request.resp.RedirectNextResp;
import com.lin.request.resp.SaveNextResp;
import com.lin.request.resp.SaveOrUpdateBlockResp;
import com.lin.request.resp.UpdateBlockPositionResp;
import com.lin.service.BlockService;
import com.lin.service.NextService;
import com.lin.service.ProcessService;

@HttpHandler
@Component
public class BlockAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BlockService blockService;

	@Autowired
	ProcessService processService;

	@Autowired
	NextService nextService;

	@Subscribe
	@RequestMapper(url = "/block-server/getSingleBlockInfo", codecName = "blockKvDecodec", clazz = GetSingleBlockInfoReq.class)
	public void getSingleBlockInfo(GetSingleBlockInfoReq req) {
		logger.debug("GetSingleBlockInfoReq:{}", req);
		GetSingleBlockInfoResp resp = new GetSingleBlockInfoResp();
		try {
			blockService.getSingleBlockInfo(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/saveOrUpdateBlock", codecName = "blockKvDecodec", clazz = SaveOrUpdateBlockReq.class)
	public void saveOrUpdateBlock(SaveOrUpdateBlockReq req) {
		logger.debug("saveOrUpdateBlock:{}", req);
		SaveOrUpdateBlockResp resp = new SaveOrUpdateBlockResp();
		try {
			blockService.saveOrUpdateBlock(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/getParamByBlocks", codecName = "blockJsonDecodec", clazz = GetParamByBlocksReq.class)
	public void getParamByBlocks(GetParamByBlocksReq req) {
		logger.debug("GetParamByBlocksReq:{}", req);
		GetParamByBlocksResp resp = new GetParamByBlocksResp();
		try {
			blockService.getParamByBlocks(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/updateBlockPosition", codecName = "blockKvDecodec", clazz = UpdateBlockPositionReq.class)
	public void updateBlockPosition(UpdateBlockPositionReq req) {
		logger.debug("UpdateBlockPositionReq:{}", req);
		UpdateBlockPositionResp resp = new UpdateBlockPositionResp();
		try {
			blockService.updateBlockPosition(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/saveNext", codecName = "blockJsonDecodec", clazz = SaveNextReq.class)
	public void saveNext(SaveNextReq req) {
		logger.debug("UpdateBlockPositionReq:{}", req);
		SaveNextResp resp = new SaveNextResp();
		try {
			nextService.saveNext(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}


	@Subscribe
	@RequestMapper(url = "/block-server/redirectNext", codecName = "blockJsonDecodec", clazz = RedirectNextReq.class)
	public void redirectNext(RedirectNextReq req) {
		logger.debug("RedirectNextReq:{}", req);
		RedirectNextResp resp = new RedirectNextResp();
		try {
			nextService.redirectNext(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}
	
	
	
	
	@Subscribe
	@RequestMapper(url = "/block-server/deleteNext", codecName = "blockKvDecodec", clazz = DeleteNextReq.class)
	public void deleteNext(DeleteNextReq req) {
		logger.debug("UpdateBlockPositionReq:{}", req);
		DeleteNextResp resp = new DeleteNextResp();
		try {
			nextService.deleteNext(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}
	
	
}
