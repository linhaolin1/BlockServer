package com.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.dao.HtmLParamDao;
import com.lin.request.req.GetHTMLParamsReq;
import com.lin.request.resp.GetHTMLParamsResp;
import com.lin.service.HTMLService;

@Service
@Transactional
public class HTMLServiceImpl implements HTMLService {

	@Autowired
	HtmLParamDao paramDao;

	@Override
	public void getHTMLParams(GetHTMLParamsReq req, GetHTMLParamsResp resp) {
		// TODO Auto-generated method stub
		resp.setEntity(paramDao.findById(req.getId()));
	}

}
