package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class SendSmsReq {
	@PluginMethodParamAnnotation(displayName = "区域", fieldName = "")
	String region;
	@PluginMethodParamAnnotation(displayName = "appKey", fieldName = "")
	String appKey;
	@PluginMethodParamAnnotation(displayName = "appSecret", fieldName = "")
	String appSecret;
	@PluginMethodParamAnnotation(displayName = "目标号码", fieldName = "")
	String phoneNumber;
	@PluginMethodParamAnnotation(displayName = "签名", fieldName = "")
	String signName;
	@PluginMethodParamAnnotation(displayName = "模板id", fieldName = "")
	String templateCode;
	@PluginMethodParamAnnotation(displayName = "验证码", fieldName = "")
	String code;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
