package com.tedu.wxadmin.model;

public class examdetail {
	private int examid;//id
	private String uno;//账号
	private String examname;//真题名字
	private int rightnum;//正确题数
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public int getRightnum() {
		return rightnum;
	}
	public void setRightnum(int rightnum) {
		this.rightnum = rightnum;
	}
	
}
