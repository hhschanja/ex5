package com.choa.ex5;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;

import com.choa.member.teacher.TeacherDAOImpl;
import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

public class TeacherDAOImplTest extends MyAbstract{

	@Inject
	private TeacherDAOImpl teacherDAOImpl;
	@Inject
	private TeacherServiceImpl teacherServiceImpl;
	private static TeacherDTO teacherDTO;
	
	
	

	public void test() throws Exception{
		

	}
	
	@Test	
	public void test3() throws Exception{
		

	}
	

	@BeforeClass
	public static void test2() throws Exception{
		String data ="hyubasd29";
		teacherDTO = new TeacherDTO();
		teacherDTO.setId(data);
		teacherDTO.setPw(data);
		teacherDTO.setAge(30);
		teacherDTO.setGrade("S");
		teacherDTO.setName(data);
		teacherDTO.setFilename(data);
		teacherDTO.setOriname(data);
		teacherDTO.setSubject(data);
		teacherDTO.setHiredate(Date.valueOf("2017-06-20"));
		
	}
	
	
}
