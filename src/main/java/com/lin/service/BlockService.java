	package com.lin.service;

import com.lin.request.req.GetParamByBlocksReq;
import com.lin.request.req.GetSingleBlockInfoReq;
import com.lin.request.req.SaveNextReq;
import com.lin.request.req.SaveOrUpdateBlockReq;
import com.lin.request.req.UpdateBlockPositionReq;
import com.lin.request.resp.GetParamByBlocksResp;
import com.lin.request.resp.GetSingleBlockInfoResp;
import com.lin.request.resp.SaveNextResp;
import com.lin.request.resp.SaveOrUpdateBlockResp;
import com.lin.request.resp.UpdateBlockPositionResp;

public interface BlockService {

	public void getSingleBlockInfo(GetSingleBlockInfoReq req, GetSingleBlockInfoResp resp);

	public void saveOrUpdateBlock(SaveOrUpdateBlockReq req, SaveOrUpdateBlockResp resp);

	public void getParamByBlocks(GetParamByBlocksReq req, GetParamByBlocksResp resp);

	public void updateBlockPosition(UpdateBlockPositionReq req, UpdateBlockPositionResp resp);


}
