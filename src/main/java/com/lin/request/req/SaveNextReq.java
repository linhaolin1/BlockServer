package com.lin.request.req;

import com.alibaba.fastjson.JSONArray;
import com.lin.nettyserver.http.bean.Propertyable;

public class SaveNextReq extends Propertyable {
	private String name;
	private JSONArray condition;
	private Integer from;
	private Integer to;
	private Integer nextId;
	private Integer position;

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getNextId() {
		return nextId;
	}

	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JSONArray getCondition() {
		return condition;
	}

	public void setCondition(JSONArray condition) {
		this.condition = condition;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

}
