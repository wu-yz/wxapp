package com.tedu.wxadmin.service;
import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.user;

public interface IUserService {
	public PageResult<user> findPageResult(user condition,Integer page,Integer pagesize);//显示页面

	public void save(user u);//保存结果

	public void update(user u);//更新用户的信息

	public void deleteByUno(String uno);//根据账号删除

	public user findByUno(String id);//根据账号查用户
	
	public int findCountByUno(String uno);//寻找Uno账号是否存在
	
	/****************************前端来的******************************/

	public boolean login(String userno, String userpwd);//登录

	public PageResult<user> logintest(String userno, String userpwd);//登录测试

	public boolean register(user u);//注册~
	
	public PageResult<user> userupdate(String uno,String uname,String upwd);//更新用户的信息

	//public PageResult<user> findJsonByUno(String userno);//根据账号
	
}
