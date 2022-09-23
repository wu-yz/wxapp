package com.tedu.wxadmin.model;

public class Testwrong {
	private int tid;//id(数据库中自增长)
	private String uno;//账号
	private int quesno;//题号（这个题在题库是第几题）
	private String selected;//用户选择的答案
	//private String state;//状态(right或者wrong)
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public int getQuesno() {
		return quesno;
	}
	public void setQuesno(int quesno) {
		this.quesno = quesno;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
	
}
