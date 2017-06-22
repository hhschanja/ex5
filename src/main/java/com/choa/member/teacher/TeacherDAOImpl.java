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
		
		int result1 = sqlSession.insert(NAMESPACE2+"memberJoin", memberDTO);
		int result2 = sqlSession.insert(NAMESPACE+"teacherJoin", memberDTO);
		
		if(result1==1 && result2 ==1){
			result = 1;
		}
		
		return result;
	}
	
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"teacherLogin", memberDTO);
	}

}
