package com.tedu.wxadmin.model;

public class QUESResult {
	private int success = 1;
	private String msg = "";
	public QUESResult(int success,String msg) {
		this.success = success;
		this.msg = msg;
	}
	public QUESResult() {
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
