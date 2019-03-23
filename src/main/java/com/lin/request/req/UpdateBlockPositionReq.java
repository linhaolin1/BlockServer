package com.lin.request.req;

import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.bean.Propertyable;

public class UpdateBlockPositionReq extends Propertyable {
	@KvField
	Integer block;
	@KvField
	private Integer positionX = 0;
	@KvField
	private Integer positionY = 0;

	public Integer getPositionX() {
		return positionX;
	}

	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}

	public Integer getPositionY() {
		return positionY;
	}

	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}

	public Integer getBlock() {
		return block;
	}

	public void setBlock(Integer block) {
		this.block = block;
	}

}
