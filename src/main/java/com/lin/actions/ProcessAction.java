package com.lin.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.Subscribe;
import com.lin.constants.BlockConstant;
import com.lin.constants.Result;
import com.lin.nettyserver.http.annotation.HttpHandler;
import com.lin.nettyserver.http.annotation.RequestMapper;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedReq;
import com.lin.nettyserver.http.util.ResponseUtil;
import com.lin.request.req.CheckAllBlockAvailableReq;
import com.lin.request.req.CheckAllLineAvailableReq;
import com.lin.request.req.CheckAllParamAvailableReq;
import com.lin.request.req.DeleteProcessArgsReq;
import com.lin.request.req.GetProcessListReq;
import com.lin.request.req.GetProcessReq;
import com.lin.request.req.ProcessReq;
import com.lin.request.req.SaveProcessArgsReq;
import com.lin.request.req.SaveProcessReq;
import com.lin.request.req.UpdateProcessReq;
import com.lin.request.resp.DeleteProcessArgsResp;
import com.lin.request.resp.GetProcessListResp;
import com.lin.request.resp.GetProcessResp;
import com.lin.request.resp.ProcessResp;
import com.lin.request.resp.SaveProcessArgsResp;
import com.lin.request.resp.SaveProcessResp;
import com.lin.request.resp.UpdateProcessResp;
import com.lin.service.ProcessService;
import com.lin.service.SequenceService;

@HttpHandler
@Component
public class ProcessAction {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProcessService processService;

	@Autowired
	SequenceService sequenceService;

	@Subscribe
	@RequestMapper(url = "/block-server/kvRequest", codecName = "blockKvDecodec", clazz = ProcessReq.class)
	public void kvRequest(ProcessReq req) {
		logger.info("BlockReq:{}", req);
		Long sequenceId = sequenceService.genpProcessSequence(req.getProcessId());
		Long time = System.currentTimeMillis();
		ProcessResp resp = new ProcessResp();
		try {
			sequenceService.save(BlockConstant.PROCESS_SEQUENCE_REQUEST, sequenceId, time, req.getProcessId(), null, null,
					JSON.toJSONString(req.getObject()));
			time=System.currentTimeMillis();
			
			processService.executeProcess(req, resp, sequenceId);
			sequenceService.save(BlockConstant.PROCESS_SEQUENCE_HANDLED, sequenceId, System.currentTimeMillis() - time,
					req.getProcessId(), null, null, JSON.toJSONString(req.getObject()));
			time=System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		}
		ResponseUtil.response(req, JSON.toJSONString(resp));
	}

	@Subscribe
	@RequestMapper(url = "/block-server/jsonRequest", codecName = "blockJsonDecodec", clazz = ProcessReq.class)
	public void jsonRequest(ProcessReq req) {
		logger.info("BlockReq:{}", req);
		Long sequenceId = sequenceService.genpProcessSequence(req.getProcessId());
		Long time = System.currentTimeMillis();
		ProcessResp resp = new ProcessResp();
		try {
			sequenceService.save(BlockConstant.PROCESS_SEQUENCE_REQUEST, sequenceId, time, req.getProcessId(), null, null,
					JSON.toJSONString(req.getObject()));
			time=System.currentTimeMillis();
			processService.executeProcess(req, resp, sequenceId);
			sequenceService.save(BlockConstant.PROCESS_SEQUENCE_HANDLED, sequenceId, System.currentTimeMillis() - time,
					req.getProcessId(), null, null, JSON.toJSONString(req.getObject()));
			time=System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		}
		ResponseUtil.response(req, JSON.toJSONString(resp));
	}

	@Subscribe
	public void dynamicRequest(UnspecifiedReq req) {
		// 寻找url匹配的process
		ProcessReq process = new ProcessReq();
		process.setObject(req.getObject());
		ProcessResp resp = new ProcessResp();
		Long time = System.currentTimeMillis();
		
		try {
			process.setProcessId(processService.getProcessByUrl(req.getUrl()));
			Long sequenceId = sequenceService.genpProcessSequence(processService.getProcessByUrl(req.getUrl()));
			sequenceService.save(BlockConstant.PROCESS_SEQUENCE_REQUEST, sequenceId, time,
					processService.getProcessByUrl(req.getUrl()), null, null, JSON.toJSONString(req.getObject()));
			time=System.currentTimeMillis();
			processService.executeProcess(process, resp, sequenceId);
			sequenceService.save(BlockConstant.PROCESS_SEQUENCE_HANDLED, sequenceId, System.currentTimeMillis() - time,
					processService.getProcessByUrl(req.getUrl()), null, null, JSON.toJSONString(req.getObject()));
			time=System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		}
		ResponseUtil.response(req, JSON.toJSONString(resp));
	}

	@Subscribe
	@RequestMapper(url = "/block-server/saveProcess", codecName = "blockKvDecodec", clazz = SaveProcessReq.class)
	public void saveProcess(SaveProcessReq req) {
		logger.debug("BlockReq:{}", req);
		SaveProcessResp resp = new SaveProcessResp();
		try {
			processService.saveNewProcess(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/getProcess", codecName = "blockKvDecodec", clazz = GetProcessReq.class)
	public void getProcess(GetProcessReq req) {
		logger.debug("GetProcessReq:{}", req);
		GetProcessResp resp = new GetProcessResp();
		try {
			processService.getProcess(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);

			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/updateProcess", codecName = "blockJsonDecodec", clazz = UpdateProcessReq.class)
	public void updateProcess(UpdateProcessReq req) {
		logger.debug("UpdateProcessReq:{}", req);
		UpdateProcessResp resp = new UpdateProcessResp();
		try {
			processService.updateProcess(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/saveProcessArgs", codecName = "blockJsonDecodec", clazz = SaveProcessArgsReq.class)
	public void saveProcessArgs(SaveProcessArgsReq req) {
		logger.debug("UpdateProcessReq:{}", req);
		SaveProcessArgsResp resp = new SaveProcessArgsResp();
		try {
			processService.saveProcessArgs(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/deleteProcessArgs", codecName = "blockJsonDecodec", clazz = DeleteProcessArgsReq.class)
	public void deleteProcessArgs(DeleteProcessArgsReq req) {
		logger.debug("UpdateProcessReq:{}", req);
		DeleteProcessArgsResp resp = new DeleteProcessArgsResp();
		try {
			processService.deleteProcessArgs(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/checkAllLineAvailable", codecName = "blockKvDecodec", clazz = CheckAllLineAvailableReq.class)
	public void checkAllLineAvailable(CheckAllLineAvailableReq req) {
		// logger.debug("CheckAllLineAvailableReq:{}", req);
		// CheckAllLineAvailableResp resp = new CheckAllLineAvailableResp();
		// try {
		// processService.checkAllLineAvailable(req, resp);
		// } catch (Exception e) {
		// e.printStackTrace();
		// resp.setResult(Result.ERROR_SYSTEM);
		// resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		// } finally {
		// ResponseUtil.response(req, JSON.toJSONString(resp));
		// }
	}

	@Subscribe
	@RequestMapper(url = "/block-server/getProcessList", codecName = "blockKvDecodec", clazz = GetProcessListReq.class)
	public void getProcessList(GetProcessListReq req) {
		logger.debug("GetProcessReq:{}", req);
		GetProcessListResp resp = new GetProcessListResp();
		try {
			processService.getProcessList(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/checkAllParamAvailable", codecName = "blockKvDecodec", clazz = CheckAllParamAvailableReq.class)
	public void checkAllParamAvailable(CheckAllParamAvailableReq req) {
		// logger.debug("CheckAllParamAvailableReq:{}", req);
		// CheckAllParamAvailableResp resp = new CheckAllParamAvailableResp();
		// try {
		// processService.checkAllParamAvailable(req, resp);
		// } catch (Exception e) {
		// e.printStackTrace();
		// resp.setResult(Result.ERROR_SYSTEM);
		// resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		// } finally {
		// ResponseUtil.response(req, JSON.toJSONString(resp));
		// }
	}

	@Subscribe
	@RequestMapper(url = "/block-server/checkAllBlockAvailable", codecName = "blockKvDecodec", clazz = CheckAllBlockAvailableReq.class)
	public void checkAllBlockAvailable(CheckAllBlockAvailableReq req) {
		// logger.debug("CheckAllBlockAvailableReq:{}", req);
		// CheckAllBlockAvailableResp resp = new CheckAllBlockAvailableResp();
		// try {
		// processService.checkAllBlockAvailable(req, resp);
		// } catch (Exception e) {
		// e.printStackTrace();
		// resp.setResult(Result.ERROR_SYSTEM);
		// resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		// } finally {
		// ResponseUtil.response(req, JSON.toJSONString(resp));
		// }
	}

}
