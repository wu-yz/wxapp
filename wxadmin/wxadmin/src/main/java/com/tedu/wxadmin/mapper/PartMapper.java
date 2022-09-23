package com.tedu.wxadmin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.wxadmin.model.part;
import com.tedu.wxadmin.model.partdetail;

@Mapper
public interface PartMapper {
	/*真题集相关*/
	public int findCountByMap(Map<String, Object> map);

	public List<part> findPartByMap(Map<String,Object> map);

	public void insert(part p);//新增 
	
	public void update(part p);//更新
	
	public void delete(int pid);//删除
	
	public part findPartById(int pid);//根据id寻找真题集

	public List<part> queryList();//查询所有
	
	/************下面是真题题目详情相关**************/
	public int findNumByMap(Map<String, Object> map);//几条记录

	public List<partdetail> findDPartByMap(Map<String, Object> map);//具体的数据

	public int updateById(partdetail p);// 根据题目id修改题目信息

	public partdetail findByContent(String content);// 根据题目内容修改题目信息

	public int addBatchPart(List<partdetail> pList);// 批量添加题目数据

	public partdetail findById(int id);//根据id寻找
	
	public void deleteById(int id);//删除

	public void updatedetail(partdetail pd);//更新
	
	public void insertdetail(partdetail pd);//新增
	/*
	 *************************** 前端操作************************
	 * *********************************************************/
	
	public List<part> findPartResult();//显示真题集

	public int count(int pno);//记录数

	public List<partdetail> findByPno(int pno);//真题详情

	public int countwish(Map<String, Object> map);//寻找记录个数

	public List<partdetail> findstar(Map<String, Object> map);//寻找收藏的题目对象

	public int countwrong(String userno);//统计错题数量

	public List<partdetail> showwrong(String userno);//错题详情
	
	
	
	













	
}
