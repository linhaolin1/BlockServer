package com.lin.wechat.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class WappQrcodeReq {
	@PluginMethodParamAnnotation(displayName = "場景")
	String scene;
	@PluginMethodParamAnnotation(displayName = "token")
	String accessToken;
	@PluginMethodParamAnnotation(displayName = "頁面")
	String page;
	@PluginMethodParamAnnotation(displayName = "宽度")
	String width;
	@PluginMethodParamAnnotation(displayName = "是否透明底")
	String isHyaline;
	@PluginMethodParamAnnotation(displayName = "本地path")
	String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getIsHyaline() {
		return isHyaline;
	}

	public void setIsHyaline(String isHyaline) {
		this.isHyaline = isHyaline;
	}

}
