package com.tedu.wxadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.wxadmin.mapper.WrongMapper;
import com.tedu.wxadmin.model.Examwrong;
import com.tedu.wxadmin.model.Testwrong;
import com.tedu.wxadmin.service.IWrongService;

@Service
public class IWrongServiceImpl implements IWrongService{
	@Autowired
	WrongMapper wrongmapper;

	@Override
	public boolean add(Testwrong twrong) {//加入错题本
		//wrongmapper.insert(twrong);
		int num = wrongmapper.findCount(twrong);
		if(num>0) {
			wrongmapper.update(twrong);//若错题本中存在该题，就进行更新
			return true;
		}else if(num==0) {
			wrongmapper.insert(twrong);//错题本无该题，则进行插入操作
			return true;
		}
		else
			return false;
	}

	
	/***************************真题错题操作**************************/
	@Override
	public boolean addexamWrong(String userno, int issue_id, String select) {
		Examwrong ew = new Examwrong();
		ew.setUno(userno);
		ew.setId(issue_id);
		ew.setSelected(select);
		int num = wrongmapper.findewrong(ew);
		if(num>0) {
			wrongmapper.updateEwrong(ew);
			return true;
		}else if(num==0){
			wrongmapper.insertEwrong(ew);
			return true;
		}
		else
			return false;
	}
	
}
