package com.choa.member;


public interface MemberDAO {
	
	public int memberJoin(MemberDTO memberDTO)throws Exception;
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;

}
