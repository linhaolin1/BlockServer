package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class WechatPayReq {
	@PluginMethodParamAnnotation(displayName = "APPID")
	String appid;
	@PluginMethodParamAnnotation(displayName="商户ID")
	String mch_id;
	@PluginMethodParamAnnotation(displayName="订单号")
	String product_id;
	
	
	String openid;
	String is_subscribe;
	
	
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	
}
