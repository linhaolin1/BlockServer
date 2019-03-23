package com.lin.request.req;

import com.lin.nettyserver.http.bean.Propertyable;

public class RedirectNextReq extends Propertyable {
	private Integer from;
	private Integer to;
	private Integer nextId;
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
	public Integer getNextId() {
		return nextId;
	}
	public void setNextId(Integer nextId) {
		this.nextId = nextId;
	}
	
}
