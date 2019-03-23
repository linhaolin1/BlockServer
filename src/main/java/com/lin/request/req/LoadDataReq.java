package com.lin.request.req;

import java.util.List;
import java.util.Map;

import com.lin.nettyserver.http.bean.Propertyable;

public class LoadDataReq extends Propertyable {
	String tableName;
	Integer page;
	Integer pageSize;
	Map<String,List> query;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, List> getQuery() {
		return query;
	}

	public void setQuery(Map<String, List> query) {
		this.query = query;
	}

	

}
