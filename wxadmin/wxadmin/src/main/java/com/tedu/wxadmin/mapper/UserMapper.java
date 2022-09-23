package com.tedu.wxadmin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.wxadmin.model.user;
@Mapper
public interface UserMapper {

	public int findCountByMap(Map<String,Object> map);//统计有多少条数据
	
	public List<user> findUserByMap(Map<String,Object> map);//查询所有用户信息

	public void insertuser(user u);//向user表新增用户

	public void updateuser(user u);//更新更新

	public user selectUser(user u);//查询用户（登录用）

	public void deleteByNo(String uno);//删除

	public user findByUno(String id);//根据id查用户

	public int findCountByUno(String uno);//寻找Uno账号是否存在

	
	/*******************************************/
	
	public void register(user u);//注册
	

}
