package com.tedu.wxadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.wxadmin.mapper.WishMapper;
import com.tedu.wxadmin.model.Wish;
import com.tedu.wxadmin.service.IWishService;
@Service
public class IWishServiceImpl implements IWishService{
	@Autowired
	WishMapper wmapper;
	@Override
	public boolean savewish(String userno,int quesid, String source) {//收藏题目
		Wish w = new Wish();
		w.setQuesid(quesid);
		w.setSource(source);
		w.setUno(userno);
		int num = wmapper.findwish(w);//查找这个题是不是在
		if(num==0) {
			wmapper.insert(w);
			return true;
		}	
		return false;
	}
	
	
	@Override
	public int findwish(String userno, int quesid, String source) {//查询
		Wish w = new Wish();
		w.setQuesid(quesid);
		w.setSource(source);
		w.setUno(userno);
		return wmapper.findwish(w);
	}


	@Override
	public boolean deletewish(String userno, int quesid, String source) {//移出收藏夹
		Wish w = new Wish();
		w.setQuesid(quesid);
		w.setSource(source);
		w.setUno(userno);
		wmapper.deletewish(w);
		return true;
	}
	
}
