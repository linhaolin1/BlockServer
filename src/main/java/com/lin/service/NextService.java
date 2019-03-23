package com.lin.service;

import com.lin.request.req.DeleteNextReq;
import com.lin.request.req.RedirectNextReq;
import com.lin.request.req.SaveNextReq;
import com.lin.request.resp.DeleteNextResp;
import com.lin.request.resp.RedirectNextResp;
import com.lin.request.resp.SaveNextResp;

public interface NextService {
	public void saveNext(SaveNextReq req, SaveNextResp resp);

	public void deleteNext(DeleteNextReq req, DeleteNextResp resp);

	public void redirectNext(RedirectNextReq req, RedirectNextResp resp);
}
