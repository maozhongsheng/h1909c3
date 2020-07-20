package com.xiaoshu.entity;

public class CountVo {
	private String cname;
	private Integer num;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "CountVo [cname=" + cname + ", num=" + num + "]";
	}
	
	
	
}
