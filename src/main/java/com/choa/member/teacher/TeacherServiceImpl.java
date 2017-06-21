package com.choa.member.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;
import com.choa.member.MemberService;

@Service
public class TeacherServiceImpl implements MemberService{

	@Autowired
	private TeacherDAOImpl teacherDAOImpl;
	
	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		return teacherDAOImpl.memberJoin(memberDTO);
	}

}
