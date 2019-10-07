package com.lin.process.req;

import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class TransferReq {
	@PluginMethodParamAnnotation(displayName = "订单号", fieldName = "")
	String out_biz_no;
	@PluginMethodParamAnnotation(displayName = "账号", fieldName = "")
	String payee_account;
	@PluginMethodParamAnnotation(displayName = "金额", fieldName = "")
	String amount;
	@PluginMethodParamAnnotation(displayName = "付款方", fieldName = "")
	String payer_show_name;
	@PluginMethodParamAnnotation(displayName = "收款方", fieldName = "")
	String payee_real_name;
	@PluginMethodParamAnnotation(displayName = "备注", fieldName = "")
	String remark;

	public String getOut_biz_no() {
		return out_biz_no;
	}

	public void setOut_biz_no(String out_biz_no) {
		this.out_biz_no = out_biz_no;
	}

	public String getPayee_account() {
		return payee_account;
	}

	public void setPayee_account(String payee_account) {
		this.payee_account = payee_account;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayer_show_name() {
		return payer_show_name;
	}

	public void setPayer_show_name(String payer_show_name) {
		this.payer_show_name = payer_show_name;
	}

	public String getPayee_real_name() {
		return payee_real_name;
	}

	public void setPayee_real_name(String payee_real_name) {
		this.payee_real_name = payee_real_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
