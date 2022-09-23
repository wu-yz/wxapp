package com.tedu.wxadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.QUESResult;
import com.tedu.wxadmin.model.banklist;
import com.tedu.wxadmin.model.user;
import com.tedu.wxadmin.service.IUserService;

@Controller
@RequestMapping("userpages")
public class UserController {
	@Autowired
	IUserService userService;
	
	@RequestMapping("user")
	public String user() {
		System.out.println("u");
		return "userpages/user";
	}
	//修改用户信息
	@RequestMapping("updateuser")
	public String updatebank(Model model,String uno) {
		//System.out.println("修改题库信息id="+id);
		user u = userService.findByUno(uno);
		model.addAttribute("u",u);
		return "userpages/updateuser";
	}
	
	//添加用户
	@RequestMapping("adduser")
	public String adduser() {
		return "userpages/adduser";
	}
	
	/*@RequestMapping*/
	@RequestMapping("listJson")
	//把模型转为Json数据
	/*page：显示的当前页
	* limit:每次显示多少条*/
	@ResponseBody
	public PageResult<user> listJson(Integer page,Integer limit){
		
		PageResult<user> uresult = userService.findPageResult(null,page,limit);//limit即pagesize	 
		return uresult;
	}
	
	@RequestMapping("save")
	@ResponseBody
	//返回结果
	public QUESResult save(user u) {
		QUESResult result = new QUESResult();
		int count = userService.findCountByUno(u.getUno());
		if(count==0) {//判断新增还是更新
			userService.save(u);//新增
		}else {
			userService.update(u);//
		}		
		System.out.println(u);	
		return result;
	}
	
	@RequestMapping("deleteuser")//删除
	@ResponseBody
	public QUESResult deleteuser(String uno) {
		//int bno = Integer.parseInt(id);
		QUESResult result = new QUESResult();
		userService.deleteByUno(uno);
		return result;
	}
	
	/*用户在小程序：
	 * 1、登录
	 * 2、显示用户信息（根据用户）
	 * 
	 * *******************************************/
	@RequestMapping("/login")
	@ResponseBody
	public boolean login(String userno,String userpwd) {//用户登录
		System.out.println("小程序接口账号："+userno+"密码"+userpwd);
		boolean login=userService.login(userno,userpwd);
		if(login) {
			return true;
		}
		return false;
		
	}
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(String uno,String uname,String upwd) {//注册
		System.out.println("用户："+uname);
		user u = new user();
		u.setUno(uno);
		u.setUname(uname);
		//u.setUemail(uemail);
		u.setUpwd(upwd);
		boolean reg=userService.register(u);
		return reg;
	}
	
	@RequestMapping("/logintest")
	@ResponseBody
	public PageResult logintest(String userno,String userpwd){//登录用这个！！！！
		System.out.println("小程序接口账号："+userno+"密码"+userpwd);
		
		//boolean login=userService.login(userno,userpwd);
		//if(login) {
		PageResult<user> uresult = userService.logintest(userno,userpwd);
		return uresult;
		//	return true;
		//}
	}
	
	@RequestMapping("/userChange")
	@ResponseBody
	public PageResult userChange(String uno,String uname,String upwd) {//修改个人信息
		System.out.println("修改"+uno);
		user u=new user();
		u.setUname(uname);
		u.setUno(uno);
		u.setUpwd(upwd);
		PageResult<user> uresult = userService.userupdate(uno,uname,upwd);
		//boolean res=userService.userupdate(u);
		return uresult;
	}
	

	
}
