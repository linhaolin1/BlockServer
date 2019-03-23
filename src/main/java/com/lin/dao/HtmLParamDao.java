package com.lin.dao;

import org.springframework.stereotype.Repository;

import com.lin.entity.HtmlParamEntity;

@Repository
public class HtmLParamDao extends BaseDao {

	public HtmlParamEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return template.selectOne("htmlParamDao.findById",id);
	}

}
