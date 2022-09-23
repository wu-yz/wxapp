package com.tedu.wxadmin.service;

import java.util.List;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.banklist;

public interface IBankService {
	
	public PageResult<banklist> findPageResult(banklist condition,int page,int pagesize);//显示页面
	
	public void save(banklist list);//增加一个新的题库进行保存
	
	public void deleteByBid(int id);//根据题库id进行删除
	
	public banklist findByBankId(int id);//根据id查找
	
	public void update(banklist list);//更新一下

	public List<banklist> nameList();//获得所有科目名
}
