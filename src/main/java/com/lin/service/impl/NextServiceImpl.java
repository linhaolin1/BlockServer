package com.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.lin.dao.NextDao;
import com.lin.dao.NextRequirementDao;
import com.lin.entity.NextEntity;
import com.lin.request.req.DeleteNextReq;
import com.lin.request.req.RedirectNextReq;
import com.lin.request.req.SaveNextReq;
import com.lin.request.resp.DeleteNextResp;
import com.lin.request.resp.RedirectNextResp;
import com.lin.request.resp.SaveNextResp;
import com.lin.service.NextService;

@Service
@Transactional
public class NextServiceImpl implements NextService {

	@Autowired
	NextDao nextDao;

	@Autowired
	NextRequirementDao requirmentDao;

	@Override
	public void saveNext(SaveNextReq req, SaveNextResp resp) {
		// TODO Auto-generated method stub
		NextEntity next = new NextEntity();
		if (req.getNextId() != null && req.getNextId() > 0) {
			next = nextDao.findFromTempById(req.getNextId());
			requirmentDao.deleteByNextFromTemp(req.getNextId());
			nextDao.deleteFromTempByBlockAndValue(req.getFrom(), req.getTo(), req.getNextId());
		} else {
			nextDao.deleteFromTempByBlockAndValue(req.getFrom(), req.getTo(), null);
		}

		next.setName(req.getName());
		next.setBlock(req.getFrom());
		next.setValue(req.getTo());
		next.setPosition(req.getPosition());

		if (req.getNextId() != null && req.getNextId() > 0) {
			nextDao.updateToTemp(next);
		} else {
			nextDao.addToTemp(next);
		}

		for (int i = 0; i < req.getCondition().size(); i++) {
			JSONObject ob = req.getCondition().getJSONObject(i);
			ob.put("next", next.getId());
			requirmentDao.addToTemp(ob);
		}

		resp.setNext(next);
	}

	@Override
	public void deleteNext(DeleteNextReq req, DeleteNextResp resp) {
		// TODO Auto-generated method stub

		if (req.getNextId() != null && req.getNextId() > 0) {
			nextDao.deleteFromTemp(req.getNextId());
			requirmentDao.deleteByNextFromTemp(req.getNextId());
		}
	}

	@Override
	public void redirectNext(RedirectNextReq req, RedirectNextResp resp) {
		// TODO Auto-generated method stub
		NextEntity next = nextDao.findFromTempById(req.getNextId());
		next.setValue(req.getTo());
		next.setBlock(req.getFrom());
		nextDao.updateToTemp(next);

	}
}
