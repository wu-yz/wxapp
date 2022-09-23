package com.tedu.wxadmin.service;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.question;
public interface IQuesService {

	public PageResult<question> findPageResult(question condition, int page, int limit);//显示页面数据

	public question findByQid(int qno);//根据no查找
	
	public void save(question q);//保存
	
	public void update(question q);//更新题目信息
	



	//boolean // 批量添加用户数据
	/*
	 * public boolean addBatchQues(List<question> quesList);
	 * 
	 * 
	 * 
	 * 
	 * // 根据题id修改用户信息 public boolean updateQuesById(question q);
	 */
	
	// 批量导入题目信息
    public boolean importQuesInfo(String fileName, InputStream is);

	public void deleteByQid(int id);//根据id删除题目
	
	/****************小程序*****************/

	public PageResult findchapter(int bno);//根据bankid查章节

	public PageResult<question> quesByChapId(int bankid, String chapter);//章节、id返回题目信息

	public PageResult<question> showwrong(String userno);//查询错题

	public PageResult<question> showtestwish(String userno, String source);//收藏夹




	
	
}
