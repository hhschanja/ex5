 package com.choa.member.student;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;

@Repository
public class StudentDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "StudentMapper."; //static으로 하면 학생과 선생이 같은 영역으로 가기 때문에 혹 같은이름이면 덮어 쓸 수도 있음..
	private final String NAMESPACE2 = "MemberMapper.";
	
	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		int result = 0;
		int result1 = sqlSession.insert(NAMESPACE2+"memberJoin", memberDTO);
		int result2 = sqlSession.insert(NAMESPACE+"studentJoin", memberDTO);
		
		if(result1==1 && result2==1){
			result = 1;
		}
		
		return result;
	}
	
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"studentLogin", memberDTO);
	}
	

}
