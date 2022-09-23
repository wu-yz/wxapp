package com.tedu.wxadmin.model;

public class user {
	//private int uid;//id编号
	private String uno;//账号
	private String uname;//用户名
	//private String uemail;//邮箱
	private String upwd;//密码
	
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
//	public String getUemail() {
//		return uemail;
//	}
//	public void setUemail(String uemail) {
//		this.uemail = uemail;
//	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	@Override
	public String toString() {
		return "user [uno=" + uno + ", uname=" + uname +  ", upwd=" + upwd + "]";
	}


	
	
}
