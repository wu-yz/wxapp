package com.tedu.wxadmin.model;

import java.util.List;

public class PageResult<T> {
	private int code;//0success 1failure
	private String msg;//错误信息
	private int count;//总记录数一共多少条数据
	private List<T> data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}	
}
