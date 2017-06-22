package com.choa.ex5;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;

import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDAOImpl;
import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;

public class StudentDAOImplTest extends MyAbstract{

	@Inject
	private StudentDAOImpl studentDAOImpl;
	private static StudentDTO studentDTO;
	
	@Inject
	private StudentServiceImpl studentServiceImpl;
	
	public void test() throws Exception{
		
		int result = studentDAOImpl.memberJoin(studentDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void test4() throws Exception{
		

	}
	
	@BeforeClass
	public static void makeStudent(){
		studentDTO = new StudentDTO();
		studentDTO.setId("ItsREAL33");
		studentDTO.setPw("ItsREAL33");
		studentDTO.setName("ItsREAL33");
		studentDTO.setAge(90);
		studentDTO.setGrade("R3");
		studentDTO.setFilename("ItsREAL33");
		studentDTO.setOriname("ItsREAL33");
		studentDTO.setPhone("ItsREAL33");
		studentDTO.setTid("ItsREAL33");
	}
	
	

}
