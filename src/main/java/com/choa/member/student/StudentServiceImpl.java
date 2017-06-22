package com.choa.member.student;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.choa.member.MemberDTO;
import com.choa.member.MemberService;
import com.choa.util.FileSaver;

@Service
public class StudentServiceImpl implements MemberService{

	@Inject
	private StudentDAOImpl studentDAOImpl;
	
	@Override
	public int memberJoin(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		String realPath = session.getServletContext().getRealPath("/resources/upload"); //session에서 리얼패쓰 뽑아내고
		
		FileSaver fs = new FileSaver(); //saver클래스 만들어서
		
		String filename = fs.fileSave(realPath, memberDTO.getF1()); // 리얼패쓰랑 멀티파일 보내줘서 저장하고 실제파일이름 들고오는거지 
		
		memberDTO.setFilename(filename); //그놈을 DTO에 넣어주고
		memberDTO.setOriname(memberDTO.getF1().getOriginalFilename());//DTO에도 이름값들을 넣어주고
		
		return studentDAOImpl.memberJoin(memberDTO);
	}
	
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return studentDAOImpl.memberLogin(memberDTO);
	}


}
