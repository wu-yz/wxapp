package com.tedu.wxadmin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.tedu.wxadmin.model.question;

@Mapper
public interface QuesMapper {

	public int findCountByMap(Map<String, Object> map);

	public List<question> findQuesByMap(Map<String, Object> map);

	public question findByQid(int qno);//根据id进行查找
	
	 // 批量添加题目数据
    public int addBatchQues(@Param("quesList") List<question> quesList);
    
	 // 根据题目id修改题目信息
    public int updateQuesById(question q);

	public question findQuesByContent(String content);//根据题目内容查找题目信息

	public void deleteByQid(int id);//删除
	
	public void insert(question q);//新增
	
	public void update(question q);//更新

	/*******************小程序*******************/
	
	public List findchapterlist(int bno);//查询章节

	public int count(Map<String, Object> map);//查询符合条件的题目个数

	public List<question> quesByChapId(Map<String, Object> map);//查询符合条件的题目

	public int countwrong(String uno);//错题个数

	public List<question> showwrong(String uno);//返回题目信息

	public int countwish(Map<String, Object> map);

	public List<question> findtestwish(Map<String, Object> map);


	
	
	 

	
}
