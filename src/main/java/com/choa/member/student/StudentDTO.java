package com.choa.member.student;

import com.choa.member.MemberDTO;

public class StudentDTO extends MemberDTO{

	private String sid;
	private String phone;
	private String tid;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
}
