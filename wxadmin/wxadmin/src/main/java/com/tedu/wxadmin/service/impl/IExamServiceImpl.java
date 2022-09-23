package com.tedu.wxadmin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.wxadmin.mapper.EDetailMapper;
import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.examdetail;
import com.tedu.wxadmin.service.IExamService;

@Service
public class IExamServiceImpl implements IExamService{
	@Autowired
	EDetailMapper emapper;
	@Override
	public boolean addexamdetail(String uno, String examname, int rightnum) {
		examdetail ed = new examdetail();
		ed.setExamname(examname);
		ed.setUno(uno);
		ed.setRightnum(rightnum);
		int num = emapper.finddetail(ed);//查找真题记录是否存在
		if(num>0) {
			emapper.updatedetail(ed);
			return true;
		}else if(num==0) {
			emapper.insertdetail(ed);
			return true;
		}
		else
			return false;
		
	}
	
	@Override
	public PageResult<examdetail> findAllByUno(String uno) {
		PageResult<examdetail> result = new PageResult<examdetail>();
		int num = emapper.count(uno);
		result.setCode(0);
		result.setCount(num);
		List<examdetail> list = emapper.findAllByUno(uno);
		result.setData(list);
		return result;
	}

}
