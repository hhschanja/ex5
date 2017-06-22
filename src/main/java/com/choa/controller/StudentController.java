package com.choa.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;

@Controller
@RequestMapping("/member/**") //단독으로 쓴다면 value를 쓰지 않아도 됨
public class StudentController {

	@RequestMapping("/student") //member이기 때문에 student랑teacher가 같은 member를 쓰는데 구분을 하는지 확인
	public void test(){
		System.out.println("student");
	}
	
	@Inject
	private StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value="memberJoin",method=RequestMethod.GET)
	public void memberJoin(){
		
	}
	
	@RequestMapping(value="studentJoin",method=RequestMethod.POST)
	public String studentJoin(StudentDTO studentDTO,Model model) throws Exception{ //studentDTO로 받아야 student 필드를 받잖아
		System.out.println("student");
		int result = studentServiceImpl.memberJoin(memberDTO, session);
		
		String message = "가입 실패";
		if(result>0){
			message = "가입 성공";
		}
		
		model.addAttribute("message", message).addAttribute("path", "../"); //home.jsp는 안돼, 인덱스는 무조건 루트야!!
		
		return "common/result";
	}

}
