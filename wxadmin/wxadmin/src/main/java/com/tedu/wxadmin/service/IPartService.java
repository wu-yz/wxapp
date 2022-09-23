package com.tedu.wxadmin.service;
import java.io.InputStream;
import java.util.List;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.part;
import com.tedu.wxadmin.model.partdetail;
public interface IPartService {

	/*******************真题集*********************/
	PageResult<part> findPageResult(Object object, int page, int pagesize);//看有多少真题


	
	public void insert(part p);//新增操作
	
	public void update(part p);//修改操作
	
	public void delete(int pid);//删除真题集
	
	public part findPartById(int pid);//根据id寻找真题集
	
	public List<part> queryList();
	
	/*****************真题详情（题目题目）**************/
	PageResult<partdetail> findDPageResult(Object object, int page, int pagesize);//一题一题显示哈

	public boolean importPartInfo(String fileName, InputStream is);// 批量导入真题信息
	
	public partdetail findByPid(int id);//根据id查找
	
	public void insertdetail(partdetail pd);//新增真题（单题增加）
	
	public void updatedetail(partdetail pd);//更新（编辑某道题）
	
	public void deleteissue(int id);//删除（删除某道题）

	/*
	 * 前端操作
	 * */
	public PageResult<part> findPartResult();//显示真题集

	PageResult<partdetail> finddetail(int pno);//按年份（真题id）查询题目

	PageResult<partdetail> showexamwish(String userno, String source);//真题收藏夹

	PageResult<partdetail> showwrong(String userno);//错题














}
