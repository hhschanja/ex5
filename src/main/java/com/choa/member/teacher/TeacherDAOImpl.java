package com.choa.member.teacher;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;

@Repository
public class TeacherDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="TeacherMapper.";
	private final String NAMESPACE2="MemberMapper.";
	
	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		int result = 0;
		
		int result1 = sqlSession.insert(NAMESPACE2+"joinMember", memberDTO);
		int result2 = sqlSession.insert(NAMESPACE+"joinTeacher", memberDTO);
		
		if(result1==1 && result2 ==1){
			result = 1;
		}
		
		return result;
	}

}
