package com.lin.request;

import com.lin.constants.Result;

public class CommonResp {
	private Integer result = Result.OK;
	private String msg = Result.getMsg(Result.OK);

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
