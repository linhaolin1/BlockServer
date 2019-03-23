package com.lin.request.resp;

import com.lin.entity.HtmlParamEntity;
import com.lin.request.CommonResp;

public class GetHTMLParamsResp extends CommonResp {
	HtmlParamEntity entity;

	public HtmlParamEntity getEntity() {
		return entity;
	}

	public void setEntity(HtmlParamEntity entity) {
		this.entity = entity;
	}

}
