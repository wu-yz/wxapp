package com.tedu.wxadmin.model;

public class question {
	private int quesNo;//题号
	private String quesType;//题目类型
	private String chapter;//章节
	private String content;//内容
	private String ans;//答案
	private String aoption;//a选项
	private String boption;//b选项
	private String coption;//c选项
	private String doption;//d选项
	private String analysis;//解析
	private int bankid;
	
	public int getQuesNo() {
		return quesNo;
	}
	public void setQuesNo(int quesNo) {
		this.quesNo = quesNo;
	}
	
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getQuesType() {
		return quesType;
	}
	public void setQuesType(String quesType) {
		this.quesType = quesType;
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
	
	public int getBankid() {
		return bankid;
	}
	public void setBankid(int bankid) {
		this.bankid = bankid;
	}
	@Override
	public String toString() {
		return "question [quesNo=" + quesNo + ", quesType=" + quesType +",chapter" + chapter + ", content=" + content
				+ ", ans=" + ans + ", aoption=" + aoption + ", boption=" + boption + ", coption=" + coption
				+ ", doption=" + doption + ", analysis=" + analysis + ",bankid=" + bankid + "]";
	}
	
}
