package com.lin.entity;

public class ExecuteEntity extends AbstractEntity {
	private Integer method = 0;
	private Integer block = 0;
	private String executeName;

	public String getExecuteName() {
		return executeName;
	}

	public void setExecuteName(String executeName) {
		this.executeName = executeName;
	}

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	public Integer getBlock() {
		return block;
	}

	public void setBlock(Integer block) {
		this.block = block;
	}

}
