package com.tedu.wxadmin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.wxadmin.model.Wish;

@Mapper
public interface WishMapper {

	public void insert(Wish w);//插入数据

	public int findwish(Wish w);//查询

	public void deletewish(Wish w);//删除

}
