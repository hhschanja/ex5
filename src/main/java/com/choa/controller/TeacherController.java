package com.choa.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choa.member.MemberDTO;
import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

@Controller
@RequestMapping("/member/**") //jsp에서 주소처리가 어려우니까 member로 통일
public class TeacherController {

	@RequestMapping("/teacher") //member이기 때문에 student랑teacher가 같은 member를 쓰는데 구분을 하는지 확인
	public void test(){
		System.out.println("teacher");
	}
	
	@Inject
	private TeacherServiceImpl teacherServiceImpl;
	
	@RequestMapping(value="teacherJoin",method=RequestMethod.POST)
	public String studentJoin(TeacherDTO teacherDTO,Model model) throws Exception{
		System.out.println("teacher");
		int result = teacherServiceImpl.memberJoin(teacherDTO);
		
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
		}
		
		model.addAttribute("message", message).addAttribute("path", "../");
		
		return "common/result";
	}
	
	
}
