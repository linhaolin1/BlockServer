package com.lin.entity;

public class ProcessEntity extends AbstractEntity {
	private String name;
	private String intro;
	private Integer startBlock = 0;
	private Integer endBlock = 0;
	private Integer dataSource;

	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(Integer startBlock) {
		this.startBlock = startBlock;
	}

	public Integer getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(Integer endBlock) {
		this.endBlock = endBlock;
	}

}
