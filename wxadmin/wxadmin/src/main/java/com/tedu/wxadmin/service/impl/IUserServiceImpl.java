package com.tedu.wxadmin.service.impl;
import com.tedu.wxadmin.mapper.UserMapper;
import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.user;
import com.tedu.wxadmin.service.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	UserMapper umapper;
	 @Override
	public boolean login(String userno, String userpwd) {//登录
		// TODO Auto-generated method stub
		user user1=new user();
		user1.setUno(userno);
		user1.setUpwd(userpwd);
		user u=umapper.selectUser(user1);
		if(u!=null) {
			return true;
		}
		return false;
	}

	
	@Override
	public PageResult<user> findPageResult(user condition, Integer page, Integer pagesize) {//显示所有用户信息
		PageResult<user> uresult = new PageResult<user>();
		uresult.setCode(0);
		//查询参数    设置为空
		Map<String,Object> parmas=new HashMap<String,Object>();
        //select * from user limit 0,10
		parmas.put("start", (page-1)*pagesize);
		parmas.put("pageSize", pagesize);
		//获取总记录数据
		int totalCount=umapper.findCountByMap(parmas);
		uresult.setCount(totalCount);
		//获取查询数据
		List<user> list=umapper.findUserByMap(parmas);		
		uresult.setData(list); 
		return uresult;
	}
	@Override
	public void save(user u) {//保存数据啦
		umapper.insertuser(u);
		
	}
	@Override
	public void update(user u) {//更新用户信息具体的实现
		// TODO Auto-generated method stub
		umapper.updateuser(u);
	}
	@Override
	public void deleteByUno(String uid) {//删除
		umapper.deleteByNo(uid);
	}
//	@Override
//	public boolean login(String username, String password) {//登录接口实现
//		user u = new user ();
//        u.setUname ( username );
//        u.setUpwd ( password );
//        user u1 = umapper.selectUser ( u );
//        if (u1 != null){
//            return true;
//        }
//        return false;
//	}
	@Override
	public user findByUno(String id) {//根据id查用户
		// TODO Auto-generated method stub
		return umapper.findByUno(id);
	}


	@Override
	public int findCountByUno(String uno) {//寻找Uno账号是否存在
		// TODO Auto-generated method stub
		return umapper.findCountByUno(uno);
	}

/***********************前端***********************************/
	@Override
	public PageResult<user> logintest(String userno, String userpwd) {//登录测试
		// TODO Auto-generated method stub
		user u = new user();		
		PageResult<user> uresult = new PageResult<user>();
		List<user> list = new ArrayList();
		u.setUno(userno);
		u.setUpwd(userpwd);
		user user=umapper.selectUser(u);
		list.add(user);
		if(user!=null) {
			uresult.setCode(0);
			uresult.setCount(1);
			uresult.setMsg("success");
			uresult.setData(list);
			return uresult;
		}else {
			uresult.setMsg("fail");
			return uresult;
		}
	}


	@Override
	public boolean register(user u) {//注册
		umapper.register(u);
		String id = u.getUno();
		int num=umapper.findCountByUno(id);
		if(num>0)
			return true;
		return false;
		// TODO Auto-generated method stub
		//String id = u.getUno();//获得返回值
		//if(num>0)
		//	return true;
		//return false;
	}


	@Override
	public PageResult<user> userupdate(String uno,String uname,String upwd) {//修改个人信息
		PageResult<user> uresult = new PageResult<user>();
		List<user> list = new ArrayList();
		user u=new user();
		u.setUname(uname);
		u.setUno(uno);
		u.setUpwd(upwd);
		umapper.updateuser(u);
		user user=umapper.selectUser(u);
		list.add(user);
		if(user!=null) {
			uresult.setCode(0);
			uresult.setCount(1);
			uresult.setMsg("success");
			uresult.setData(list);
			return uresult;
		}else {
			uresult.setMsg("fail");
			return uresult;
		}
	}

}
