package com.lin.service;

import com.lin.entity.BlockEntity;
import com.lin.entity.NextEntity;
import com.lin.request.req.*;
import com.lin.request.resp.*;
import com.lin.util.DataloaderInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ExecuteService {

	void saveExecuteParam(SaveExecuteParamReq req, SaveExecuteParamResp resp);

	void saveExecute(SaveExecuteReq req, SaveExecuteResp resp);

	void getExecuteVariableParams(GetExecuteVariableParamsReq req, GetExecuteVariableParamsResp resp);

	public void getExecuteParams(GetExecuteParamsReq req, GetExecuteParamsResp resp);

	public List<NextEntity> executeBlock(BlockEntity block, DataloaderInterface loader, Long sequenceId, ExportProcessResp resp)
			throws InvocationTargetException;

	void deleteExecute(DelExecuteReq req, DelExecuteResp resp);

}
