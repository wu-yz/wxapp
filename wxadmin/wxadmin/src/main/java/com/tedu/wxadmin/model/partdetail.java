package com.tedu.wxadmin.model;

public class partdetail {
	private int id;
	private String type;//题目类型
	private String content;//题目描述
	private String ans;//答案
	private String aoption;//a选项
	private String boption;//b选项
	private String coption;//c选项
	private String doption;//d选项
	private String analysis;//解析
	private int partNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getAoption() {
		return aoption;
	}
	public void setAoption(String aoption) {
		this.aoption = aoption;
	}
	public String getBoption() {
		return boption;
	}
	public void setBoption(String boption) {
		this.boption = boption;
	}
	public String getCoption() {
		return coption;
	}
	public void setCoption(String coption) {
		this.coption = coption;
	}
	public String getDoption() {
		return doption;
	}
	public void setDoption(String doption) {
		this.doption = doption;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public int getPartNo() {
		return partNo;
	}
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}
	@Override
	public String toString() {
		return "partdetail [id=" + id + ", type=" + type + ", content=" + content + ", ans=" + ans + ", aoption="
				+ aoption + ", boption=" + boption + ", coption=" + coption + ", doption=" + doption + ", analysis="
				+ analysis + ", partNo=" + partNo + "]";
	}
	
}
