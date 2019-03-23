package com.lin.request.resp;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.lin.entity.BlockEntity;
import com.lin.entity.ExecuteEntity;
import com.lin.entity.ProcessArgumentComplexEntity;
import com.lin.entity.ProcessArgumentEntity;
import com.lin.entity.ProcessEntity;
import com.lin.request.CommonResp;

public class GetProcessResp extends CommonResp {
	private ProcessEntity process;
	private List<BlockEntity> blocks;
	private List<JSONObject> next;
	private List<ExecuteEntity> execute;
	private List<ProcessArgumentEntity> args;
	private List<ProcessArgumentComplexEntity> complex;

	public List<ProcessArgumentComplexEntity> getComplex() {
		return complex;
	}

	public void setComplex(List<ProcessArgumentComplexEntity> complex) {
		this.complex = complex;
	}

	public List<ProcessArgumentEntity> getArgs() {
		return args;
	}

	public void setArgs(List<ProcessArgumentEntity> args) {
		this.args = args;
	}

	public List<ExecuteEntity> getExecute() {
		return execute;
	}

	public void setExecute(List<ExecuteEntity> execute) {
		this.execute = execute;
	}

	public ProcessEntity getProcess() {
		return process;
	}

	public void setProcess(ProcessEntity process) {
		this.process = process;
	}

	public List<BlockEntity> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<BlockEntity> blocks) {
		this.blocks = blocks;
	}

	public List<JSONObject> getNext() {
		return next;
	}

	public void setNext(List<JSONObject> next) {
		this.next = next;
	}

}
