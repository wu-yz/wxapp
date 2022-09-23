package com.tedu.wxadmin.model;

public class banklist {
	private int bankno;//题库号
	private String bankname;//题库名
	//private int num;//题数
	public int getBankno() {
		return bankno;
	}
	public void setBankno(int bankno) {
		this.bankno = bankno;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	//public int getNum() {
	//	return num;
	//}
	//public void setNum(int num) {
	//	this.num = num;
	//}
	@Override
	public String toString() {
		return "banklist [bankno=" + bankno + ", bankname=" + bankname + "]";
	}
	
}
