package com.tedu.wxadmin.service;

public interface IWishService {

	public boolean savewish(String userno,int quesid, String source);//点击收藏 题目，收藏

	public int findwish(String userno, int quesid, String source);

	public boolean deletewish(String userno, int quesid, String source);//移出收藏夹（删除）
	
	
	
}
