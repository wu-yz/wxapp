package com.tedu.wxadmin.model;

public class part {
	private int partNo;//真题集id
	private String  partName;//真题集名称
	public int getPartNo() {
		return partNo;
	}
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	@Override
	public String toString() {
		return "part [partNo=" + partNo + ", partName=" + partName + "]";
	}
	
}
