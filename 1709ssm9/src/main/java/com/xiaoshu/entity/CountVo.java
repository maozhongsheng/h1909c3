package com.xiaoshu.entity;

public class CountVo {
	private String mdname;
	private Integer num;
	public String getMdname() {
		return mdname;
	}
	public void setMdname(String mdname) {
		this.mdname = mdname;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "CountVo [mdname=" + mdname + ", num=" + num + "]";
	}
	
	
}
