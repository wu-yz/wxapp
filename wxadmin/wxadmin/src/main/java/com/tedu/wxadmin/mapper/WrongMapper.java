package com.tedu.wxadmin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.wxadmin.model.Examwrong;
import com.tedu.wxadmin.model.Testwrong;

@Mapper
public interface WrongMapper {

	public void insert(Testwrong twrong);

	public int findCount(Testwrong twrong);
	
	public void update(Testwrong twrong);
	
	/**********************真题错题操作***********************/

	public int findewrong(Examwrong ew);//寻找

	public void updateEwrong(Examwrong ew);//更新

	public void insertEwrong(Examwrong ew);//新增
	
	

}
