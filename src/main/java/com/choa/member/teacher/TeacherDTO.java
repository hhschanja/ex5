package com.choa.member.teacher;

import java.sql.Date;

import com.choa.member.MemberDTO;

public class TeacherDTO extends MemberDTO{

	private String subject;
	private Date hiredate;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	
	
}
