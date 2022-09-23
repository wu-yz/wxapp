package com.tedu.wxadmin.service;

import com.tedu.wxadmin.model.Testwrong;

public interface IWrongService {

	public boolean add(Testwrong twrong);//向题集错题表添加数据
	
	
	
	/**************************下面是真题的错题操作*************************/

	public boolean addexamWrong(String userno, int issue_id, String select);//向真题错题表添加数据

}
