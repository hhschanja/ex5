package com.choa.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDTO;
import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

@Controller
@RequestMapping("/member/**") //jsp에서 주소처리가 어려우니까 member로 통일
public class TeacherController {
	
	@Inject
	private TeacherServiceImpl teacherServiceImpl;
	
	
	@RequestMapping("/teacher") //member이기 때문에 student랑teacher가 같은 member를 쓰는데 구분을 하는지 확인
	public void test(){
		System.out.println("teacher");
	}
	
	@RequestMapping(value="teacherLogin",method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO,HttpSession session) throws Exception{
		
		memberDTO = teacherServiceImpl.memberLogin(memberDTO);
				
			String message = "실패";
				
			if(memberDTO!=null){
				message = "환영합니다";
				session.setAttribute("member", memberDTO);
			}
		
			ModelAndView mv = new ModelAndView();
			mv.addObject("path", "../").addObject("message", message).setViewName("common/result");
				
			return mv;
	
	}
	
	@RequestMapping(value="teacherJoin",method=RequestMethod.POST)
	public String studentJoin(TeacherDTO teacherDTO,Model model,HttpSession session) throws Exception{
		System.out.println("teacher");
		int result = teacherServiceImpl.memberJoin(teacherDTO,session);
		
		String message = "FAIL";
		if(result>0){
			message = "SUCCESS";
		}
		
		model.addAttribute("message", message).addAttribute("path", "../");
		
		return "common/result";
	}
	
	
}
