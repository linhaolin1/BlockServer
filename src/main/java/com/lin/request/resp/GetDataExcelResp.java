package com.lin.request.resp;

import com.lin.request.CommonResp;

public class GetDataExcelResp extends CommonResp {
	String groupName;
	String path;
	String httpPath;

	public String getHttpPath() {
		return httpPath;
	}

	public void setHttpPath(String httpPath) {
		this.httpPath = httpPath;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
