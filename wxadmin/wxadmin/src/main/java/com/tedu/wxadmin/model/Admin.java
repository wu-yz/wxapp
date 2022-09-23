package com.tedu.wxadmin.model;

public class Admin {
	private String admNo;//管理员账号
	private String admName;//管理员用户名
	private String admemail;//邮箱
	private String admpwd;//密码
	public String getAdmNo() {
		return admNo;
	}
	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmemail() {
		return admemail;
	}
	public void setAdmemail(String admemail) {
		this.admemail = admemail;
	}
	public String getAdmpwd() {
		return admpwd;
	}
	public void setAdmpwd(String admpwd) {
		this.admpwd = admpwd;
	}
	@Override
	public String toString() {
		return "Admin [admNo=" + admNo + ", admName=" + admName + ", admemail=" + admemail + ", admpwd=" + admpwd + "]";
	}
	
}
