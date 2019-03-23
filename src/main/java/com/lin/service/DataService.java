package com.lin.service;

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

public interface DataService {

	public void getAvailableDataTable(GetAvailableDataTableReq req, GetAvailableDataTableResp resp);

	public void updateDataTable(UpdateDataTableReq req, UpdateDataTableResp resp);

	public void addNewTable(AddNewTableReq req, AddNewTableResp resp);

	public void findColumnByTableName(FindColumnsReq req, FindColumnsResp resp);

	public void loadData(LoadDataReq req, LoadDataResp resp);

	public void addTableData(AddTableDataReq req, AddTableDataResp resp);

	public void loadDataFromExcel(LoadDataFromExcelReq req, LoadDataFromExcelResp resp);

	public void executeLoadExcelData(ExecuteLoadExcelDataReq req, ExecuteLoadExcelDataResp resp);

	public void getModelExcel(GetModelExcelReq req, GetModelExcelResp resp);

	public void getDataExcel(GetDataExcelReq req, GetDataExcelResp resp);

}
