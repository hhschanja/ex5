package com.choa.member;

import javax.servlet.http.HttpSession;

public interface MemberService {

	public int memberJoin(MemberDTO memberDTO,HttpSession session) throws Exception;
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;
	
}
