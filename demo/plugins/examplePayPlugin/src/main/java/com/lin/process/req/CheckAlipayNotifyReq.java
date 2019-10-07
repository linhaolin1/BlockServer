package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class CheckAlipayNotifyReq {
	@PluginMethodParamAnnotation(displayName = "通知时间", fieldName = "")
	String notify_time;
	@PluginMethodParamAnnotation(displayName = "通知类型", fieldName = "")
	String notify_type;
	@PluginMethodParamAnnotation(displayName = "通知校验ID", fieldName = "")
	String notify_id;
	@PluginMethodParamAnnotation(displayName = "编码格式", fieldName = "")
	String charset;
	@PluginMethodParamAnnotation(displayName = "接口版本", fieldName = "")
	String version;
	@PluginMethodParamAnnotation(displayName = "签名类型", fieldName = "")
	String sign_type;
	@PluginMethodParamAnnotation(displayName = "签名", fieldName = "")
	String sign;
	@PluginMethodParamAnnotation(displayName = "授权方的app_id", fieldName = "")
	String auth_app_id;
	@PluginMethodParamAnnotation(displayName = "支付宝交易号", fieldName = "")
	String trade_no;
	@PluginMethodParamAnnotation(displayName = "APP ID", fieldName = "")
	String app_id;
	@PluginMethodParamAnnotation(displayName = "商户订单号", fieldName = "")
	String out_trade_no;
	@PluginMethodParamAnnotation(displayName = "商户业务号", fieldName = "")
	String out_biz_no;
	@PluginMethodParamAnnotation(displayName = "买家支付宝用户号", fieldName = "")
	String buyer_id;
	@PluginMethodParamAnnotation(displayName = "卖家支付宝用户号", fieldName = "")
	String seller_id;
	@PluginMethodParamAnnotation(displayName = "交易状态", fieldName = "")
	String trade_status;
	@PluginMethodParamAnnotation(displayName = "订单金额", fieldName = "")
	String total_amount;
	@PluginMethodParamAnnotation(displayName = "实收金额", fieldName = "")
	String receipt_amount;
	@PluginMethodParamAnnotation(displayName = "开票金额", fieldName = "")
	String invoice_amount;
	@PluginMethodParamAnnotation(displayName = "付款金额", fieldName = "")
	String buyer_pay_amount;
	@PluginMethodParamAnnotation(displayName = "集分宝金额", fieldName = "")
	String point_amount;
	@PluginMethodParamAnnotation(displayName = "总退款金额", fieldName = "")
	String refund_fee;
	@PluginMethodParamAnnotation(displayName = "订单标题", fieldName = "")
	String subject;
	@PluginMethodParamAnnotation(displayName = "商品描述", fieldName = "")
	String body;
	@PluginMethodParamAnnotation(displayName = "交易创建时间", fieldName = "")
	String gmt_create;
	@PluginMethodParamAnnotation(displayName = "交易付款时间", fieldName = "")
	String gmt_payment;
	@PluginMethodParamAnnotation(displayName = "交易退款时间", fieldName = "")
	String gmt_refund;
	@PluginMethodParamAnnotation(displayName = "交易结束时间", fieldName = "")
	String gmt_close;
	@PluginMethodParamAnnotation(displayName = "支付金额信息", fieldName = "")
	String fund_bill_list;
	@PluginMethodParamAnnotation(displayName = "优惠券信息", fieldName = "")
	String voucher_detail_list;
	@PluginMethodParamAnnotation(displayName = "回传参数", fieldName = "")
	String passback_params;

	public String getNotify_time() {
		return notify_time;
	}

	public void setNotify_time(String notify_time) {
		this.notify_time = notify_time;
	}

	public String getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAuth_app_id() {
		return auth_app_id;
	}

	public void setAuth_app_id(String auth_app_id) {
		this.auth_app_id = auth_app_id;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_biz_no() {
		return out_biz_no;
	}

	public void setOut_biz_no(String out_biz_no) {
		this.out_biz_no = out_biz_no;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getReceipt_amount() {
		return receipt_amount;
	}

	public void setReceipt_amount(String receipt_amount) {
		this.receipt_amount = receipt_amount;
	}

	public String getInvoice_amount() {
		return invoice_amount;
	}

	public void setInvoice_amount(String invoice_amount) {
		this.invoice_amount = invoice_amount;
	}

	public String getBuyer_pay_amount() {
		return buyer_pay_amount;
	}

	public void setBuyer_pay_amount(String buyer_pay_amount) {
		this.buyer_pay_amount = buyer_pay_amount;
	}

	public String getPoint_amount() {
		return point_amount;
	}

	public void setPoint_amount(String point_amount) {
		this.point_amount = point_amount;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	public String getGmt_payment() {
		return gmt_payment;
	}

	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	public String getGmt_refund() {
		return gmt_refund;
	}

	public void setGmt_refund(String gmt_refund) {
		this.gmt_refund = gmt_refund;
	}

	public String getGmt_close() {
		return gmt_close;
	}

	public void setGmt_close(String gmt_close) {
		this.gmt_close = gmt_close;
	}

	public String getFund_bill_list() {
		return fund_bill_list;
	}

	public void setFund_bill_list(String fund_bill_list) {
		this.fund_bill_list = fund_bill_list;
	}

	public String getVoucher_detail_list() {
		return voucher_detail_list;
	}

	public void setVoucher_detail_list(String voucher_detail_list) {
		this.voucher_detail_list = voucher_detail_list;
	}

	public String getPassback_params() {
		return passback_params;
	}

	public void setPassback_params(String passback_params) {
		this.passback_params = passback_params;
	}
	
	
	
}
