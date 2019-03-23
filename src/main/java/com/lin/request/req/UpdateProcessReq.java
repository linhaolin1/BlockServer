package com.lin.request.req;

import java.util.List;

import com.lin.entity.ProcessArgumentEntity;
import com.lin.nettyserver.http.bean.Propertyable;

public class UpdateProcessReq extends Propertyable {
	private String name;
	private String intro;
	private Integer processId;
	private List<ProcessArgumentEntity> inArgs;
	private List<ProcessArgumentEntity> outArgs;

	public List<ProcessArgumentEntity> getInArgs() {
		return inArgs;
	}

	public void setInArgs(List<ProcessArgumentEntity> inArgs) {
		this.inArgs = inArgs;
	}

	public List<ProcessArgumentEntity> getOutArgs() {
		return outArgs;
	}

	public void setOutArgs(List<ProcessArgumentEntity> outArgs) {
		this.outArgs = outArgs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

}
