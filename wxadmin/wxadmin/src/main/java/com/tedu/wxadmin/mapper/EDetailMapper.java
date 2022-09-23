package com.tedu.wxadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.wxadmin.model.examdetail;

@Mapper
public interface EDetailMapper {

	public int finddetail(examdetail ed);//查询

	public void updatedetail(examdetail ed);//更新
	
	public void insertdetail(examdetail ed);//插入

	public int count(String uno);//查询用户的答题记录数

	public List<examdetail> findAllByUno(String uno);//查询某一用户的所有记录

}
