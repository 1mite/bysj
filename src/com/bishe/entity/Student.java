package com.bishe.entity;


/**
 * Created by mite on 2015/5/12.
 */
public class Student {
	private Integer stuid;
	private String stuname;
	private String stupassword;
	private String stusex;
	private String stuage;
	private String stumail;
	private String subject;//学习科目
	private Integer page; //已完成章节
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getStuid() {
		return stuid;
	}
	public String getStupassword() {
		return stupassword;
	}
	public void setStupassword(String stupassword) {
		this.stupassword = stupassword;
	}
	public void setStuid(Integer stuid) {

		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStumail() {
		return stumail;
	}
	public void setStumail(String stumail) {
		this.stumail = stumail;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public String getStuage() {
		return stuage;
	}
	public void setStuage(String stuage) {
		this.stuage = stuage;
	}



}
