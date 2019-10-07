package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class RedisGetReq {
	@PluginMethodParamAnnotation(displayName = "redis地址")
	String destHost;

	@PluginMethodParamAnnotation(displayName = "redis端口")
	String port;

	@PluginMethodParamAnnotation(displayName = "redis密码")
	String pass;

	@PluginMethodParamAnnotation(displayName = "key")
	String key;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
