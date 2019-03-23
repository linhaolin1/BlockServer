package com.lin.block;

import java.util.List;

public class ProcessIntro {
//	private List<Block> blocks;
//	private Integer startBlock;
	private List<ProcessArgument> inArgs;
	private List<ProcessArgument> outArgs;
	private String name;
//
//	public Block findBlockById(Integer blockId) {
//		// TODO Auto-generated method stub
//		for (Block b : blocks) {
//			if (b.getId() == blockId) {
//				return b;
//			}
//		}
//		return null;
//	}
//
//	public List<Block> getBlocks() {
//		return blocks;
//	}
//
//	public void setBlocks(List<Block> blocks) {
//		this.blocks = blocks;
//	}
//
//	public Integer getStartBlock() {
//		return startBlock;
//	}
//
//	public void setStartBlock(Integer startBlock) {
//		this.startBlock = startBlock;
//	}
//
	public List<ProcessArgument> getInArgs() {
		return inArgs;
	}

	public void setInArgs(List<ProcessArgument> inArgs) {
		this.inArgs = inArgs;
	}

	public List<ProcessArgument> getOutArgs() {
		return outArgs;
	}

	public void setOutArgs(List<ProcessArgument> outArgs) {
		this.outArgs = outArgs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
