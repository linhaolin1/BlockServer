package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class AlipayReq {
	@PluginMethodParamAnnotation(displayName = "订单结束链接", fieldName = "")
	String returnUrl;
	@PluginMethodParamAnnotation(displayName = "订单处理链接", fieldName = "")
	String notifyUrl;
	@PluginMethodParamAnnotation(displayName = "订单号", fieldName = "")
	String out_trade_no;
	@PluginMethodParamAnnotation(displayName = "价格/元", fieldName = "")
	String total_amount;
	@PluginMethodParamAnnotation(displayName = "标题", fieldName = "")
	String subject;

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}


	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

}
