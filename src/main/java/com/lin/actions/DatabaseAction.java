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
import com.lin.request.req.AddNewTableReq;
import com.lin.request.req.AddTableDataReq;
import com.lin.request.req.ExecuteLoadExcelDataReq;
import com.lin.request.req.FindColumnsReq;
import com.lin.request.req.GetAvailableDataTableReq;
import com.lin.request.req.GetDataExcelReq;
import com.lin.request.req.GetModelExcelReq;
import com.lin.request.req.LoadDataFromExcelReq;
import com.lin.request.req.LoadDataReq;
import com.lin.request.req.UpdateDataTableReq;
import com.lin.request.resp.AddNewTableResp;
import com.lin.request.resp.AddTableDataResp;
import com.lin.request.resp.ExecuteLoadExcelDataResp;
import com.lin.request.resp.FindColumnsResp;
import com.lin.request.resp.GetAvailableDataTableResp;
import com.lin.request.resp.GetDataExcelResp;
import com.lin.request.resp.GetModelExcelResp;
import com.lin.request.resp.LoadDataFromExcelResp;
import com.lin.request.resp.LoadDataResp;
import com.lin.request.resp.UpdateDataTableResp;
import com.lin.service.DataService;

@HttpHandler
@Component
public class DatabaseAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DataService dataService;

	@Subscribe
	@RequestMapper(url = "/block-server/getAvailableDataTable", codecName = "blockKvDecodec", clazz = GetAvailableDataTableReq.class)
	public void getAvailableDataTable(GetAvailableDataTableReq req) {
		logger.debug("GetAvailableDataTableReq:{}", req);
		GetAvailableDataTableResp resp = new GetAvailableDataTableResp();
		try {
			dataService.getAvailableDataTable(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/updateDataTable", codecName = "blockKvDecodec", clazz = UpdateDataTableReq.class)
	public void updateDataTable(UpdateDataTableReq req) {
		logger.debug("UpdateDataTableReq:{}", req);
		UpdateDataTableResp resp = new UpdateDataTableResp();
		try {
			dataService.updateDataTable(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/addNewTable", codecName = "blockJsonDecodec", clazz = AddNewTableReq.class)
	public void addNewTable(AddNewTableReq req) {
		logger.debug("UpdateDataTableReq:{}", req);
		AddNewTableResp resp = new AddNewTableResp();
		try {
			dataService.addNewTable(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/findColumns", codecName = "blockJsonDecodec", clazz = FindColumnsReq.class)
	public void findColumns(FindColumnsReq req) {
		logger.debug("GetTableInfoReq:{}", req);
		FindColumnsResp resp = new FindColumnsResp();
		try {
			dataService.findColumnByTableName(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/loadData", codecName = "blockJsonDecodec", clazz = LoadDataReq.class)
	public void loadData(LoadDataReq req) {
		logger.debug("LoadDataReq:{}", req);
		LoadDataResp resp = new LoadDataResp();
		try {
			dataService.loadData(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/addTableData", codecName = "blockJsonDecodec", clazz = AddTableDataReq.class)
	public void addTableData(AddTableDataReq req) {
		logger.debug("LoadDataReq:{}", req);
		AddTableDataResp resp = new AddTableDataResp();
		try {
			dataService.addTableData(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/loadDataFromExcel", codecName = "blockJsonDecodec", clazz = LoadDataFromExcelReq.class)
	public void loadDataFromExcel(LoadDataFromExcelReq req) {
		LoadDataFromExcelResp resp = new LoadDataFromExcelResp();
		try {
			dataService.loadDataFromExcel(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}

	@Subscribe
	@RequestMapper(url = "/block-server/executeLoadExcelData", codecName = "blockJsonDecodec", clazz = ExecuteLoadExcelDataReq.class)
	public void executeLoadExcelData(ExecuteLoadExcelDataReq req) {
		ExecuteLoadExcelDataResp resp = new ExecuteLoadExcelDataResp();
		try {
			dataService.executeLoadExcelData(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}
	
	@Subscribe
	@RequestMapper(url = "/block-server/getModelExcel", codecName = "blockJsonDecodec", clazz = GetModelExcelReq.class)
	public void getModelExcel(GetModelExcelReq req){
		GetModelExcelResp resp = new GetModelExcelResp();
		try {
			dataService.getModelExcel(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}
	

	@Subscribe
	@RequestMapper(url = "/block-server/getDataExcel", codecName = "blockJsonDecodec", clazz = GetDataExcelReq.class)
	public void getDataExcel(GetDataExcelReq req){
		GetDataExcelResp resp = new GetDataExcelResp();
		try {
			dataService.getDataExcel(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg(Result.getMsg(Result.ERROR_SYSTEM));
		} finally {
			ResponseUtil.response(req, JSON.toJSONString(resp));
		}
	}
}
