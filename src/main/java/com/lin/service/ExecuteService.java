package com.lin.service;

import java.lang.reflect.InvocationTargetException;

import com.lin.entity.BlockEntity;
import com.lin.request.req.DelExecuteReq;
import com.lin.request.req.GetExecuteParamsReq;
import com.lin.request.req.GetExecuteVariableParamsReq;
import com.lin.request.req.SaveExecuteParamReq;
import com.lin.request.req.SaveExecuteReq;
import com.lin.request.resp.DelExecuteResp;
import com.lin.request.resp.ExportProcessResp;
import com.lin.request.resp.GetExecuteParamsResp;
import com.lin.request.resp.GetExecuteVariableParamsResp;
import com.lin.request.resp.SaveExecuteParamResp;
import com.lin.request.resp.SaveExecuteResp;
import com.lin.util.DataloaderInterface;

public interface ExecuteService {

	void saveExecuteParam(SaveExecuteParamReq req, SaveExecuteParamResp resp);

	void saveExecute(SaveExecuteReq req, SaveExecuteResp resp);

	void getExecuteVariableParams(GetExecuteVariableParamsReq req, GetExecuteVariableParamsResp resp);

	public void getExecuteParams(GetExecuteParamsReq req, GetExecuteParamsResp resp);

	public Integer executeBlock(BlockEntity block, DataloaderInterface loader, Long sequenceId, ExportProcessResp resp)
			throws InvocationTargetException;

	void deleteExecute(DelExecuteReq req, DelExecuteResp resp);

}
