package com.lin.process.req;

import java.util.HashMap;
import java.util.Map;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodVariableParamAnnotation;

public class RedisSetReq {
	@PluginMethodParamAnnotation(displayName = "redis地址")
	String destHost;

	@PluginMethodParamAnnotation(displayName = "redis端口")
	String port;

	@PluginMethodParamAnnotation(displayName = "redis密码")
	String pass;

	@PluginMethodParamAnnotation(displayName = "设置数量")
	String count;

	@PluginMethodVariableParamAnnotation()
	Map<String, Object> keyMap;

	@PluginMethodVariableParamAnnotation()
	Map<String, Object> valueMap;

	public String getDestHost() {
		return destHost;
	}

	public void setDestHost(String destHost) {
		this.destHost = destHost;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Map<String, Object> getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(Map<String, Object> keyMap) {
		this.keyMap = keyMap;
	}

	public Map<String, Object> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<String, Object> valueMap) {
		this.valueMap = valueMap;
	}

}
