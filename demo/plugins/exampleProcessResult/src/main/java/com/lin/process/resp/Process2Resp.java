package com.lin.process.resp;

import java.util.Map;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.lin.interfacePackage.Annotation.PlguinMethodOutputVariableParamAnnotation;

public class Process2Resp {

	@PlguinMethodOutputVariableParamAnnotation()
	Map outMap;

	public Map getOutMap() {
		CodecCheck check;
		
		return outMap;
	}

	public void setOutMap(Map outMap) {
		this.outMap = outMap;
	}

	public static void main(String[] args) {
		CodecCheck ch=new CodecCheck();
	}
}
