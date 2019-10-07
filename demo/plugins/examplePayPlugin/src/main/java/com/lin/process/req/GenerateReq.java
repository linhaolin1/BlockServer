package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class GenerateReq {
	@PluginMethodParamAnnotation(displayName = "APPID")
	String appid;
	@PluginMethodParamAnnotation(displayName = "商户ID")
	String mch_id;
	@PluginMethodParamAnnotation(displayName = "订单号")
	String out_trade_no;
	@PluginMethodParamAnnotation(displayName = "设备号")
	String device_info;
	@PluginMethodParamAnnotation(displayName = "订单描述")
	String body;
	@PluginMethodParamAnnotation(displayName = "订单详情")
	String detail;
	@PluginMethodParamAnnotation(displayName = "备注")
	String attach;
	@PluginMethodParamAnnotation(displayName = "币种")
	String fee_type;
	@PluginMethodParamAnnotation(displayName = "总价/单位分")
	Integer total_fee;
	@PluginMethodParamAnnotation(displayName = "过期时间/分")
	String time_expire;
	@PluginMethodParamAnnotation(displayName = "优惠")
	String goods_tag;
	@PluginMethodParamAnnotation(displayName = "商品id")
	String product_id;
	@PluginMethodParamAnnotation(displayName = "场景信息")
	String scene_info;
	@PluginMethodParamAnnotation(displayName = "商户密钥")
	String aesKey;
	@PluginMethodParamAnnotation(displayName = "通知URL")
	String notify_url;

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getScene_info() {
		return scene_info;
	}

	public void setScene_info(String scene_info) {
		this.scene_info = scene_info;
	}

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

}
