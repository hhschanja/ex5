package com.choa.ex5;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.util.FileSaver;

@Controller

public class FileUploadController {

	@RequestMapping(value="/test/fileUpForm")
	public void fileUp(){
	
	}
	
	//첫번째 방법
	//@RequestMapping(value="/test/fileUp1",method=RequestMethod.POST)
	public void fileUpload1(String name, MultipartHttpServletRequest request) throws Exception{ //요 request로 일단 가지고 와서
		
		MultipartFile f = request.getFile("f1"); //파라미터 f1에 담겨있는 파일의 multipart file을 먼저 꺼내줘야해
		
		System.out.println("name:"+name);
		System.out.println("file:"+f.getName()); //파라미터 이름
		System.out.println("OriginalFile:"+f.getOriginalFilename());
		System.out.println("Size:"+f.getSize());
		
		//request.getRealPath("resources/upload"); //실제 경로를 꺼내와야하는데 request에서 꺼내면되지 (권장안하는방법)
		
		String path = request.getSession().getServletContext().getRealPath("resources/upload");
		
		FileSaver fs = new FileSaver();
		
		fs.fileSave(path, f.getOriginalFilename(), f.getBytes());
	}
	
	
	
	//2번째 방법 (파라미터를 이용) - miltipartfile 이름을 파라미터 변수이름이랑 똑같이 하면 얘가 알아서 하는거지
	//@RequestMapping(value="/test/fileUp1",method=RequestMethod.POST)
	public void fileUpload2(String name, MultipartFile f1, HttpSession session) throws Exception{ //session을 바로 받아서 쓸 수 있어
		
		System.out.println("name:"+name);
		System.out.println("file:"+f1.getName()); //파라미터 이름
		System.out.println("OriginalFile:"+f1.getOriginalFilename());
		System.out.println("Size:"+f1.getSize());
		
		String path = session.getServletContext().getRealPath("resources/upload");
		
		FileSaver fs = new FileSaver();
		
		fs.fileSave(path, f1.getOriginalFilename(), f1.getBytes());
		
	}
	
	//세번째 방법
	@RequestMapping(value="/test/fileUp1",method=RequestMethod.POST)
	public void fileUpload3(FileDTO fileDTO, HttpSession session) throws Exception{ //name과 multi를 그냥 DTO로 묶어놓은거야 왜냐면 파라미터 이름 같으면 알아서 매칭하니까
		FileSaver fs = new FileSaver();
		
		String path = session.getServletContext().getRealPath("resources/upload");
		String originName = fileDTO.getF1().getOriginalFilename();
		byte [] fileData = fileDTO.getF1().getBytes();
		
		fs.fileSave(path, originName, fileData);
	}
	
	
	
	
}
