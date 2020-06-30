package com.jiyun.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	private Integer sid;
	private String sname;
	private String sex;
	private	String  pic;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  birthday;
	private Integer cid;
	private Clazz clazz;
	
	
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", pic=" + pic + ", birthday=" + birthday
				+ ", cid=" + cid + ", clazz=" + clazz + "]";
	}
	
}
