package com.tedu.wxadmin.service;

import java.util.List;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.examdetail;

public interface IExamService {

	public boolean addexamdetail(String uno, String examname, int rightnum);//新增真题记录

	public PageResult<examdetail> findAllByUno(String uno);//显示所有记录

}
