package com.choa.ex5;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller

public class FileUploadController {

	@RequestMapping(value="/test/fileUpForm")
	public void fileUp(){
	
	}
	
	//일단 파일을 꺼내와
	@RequestMapping(value="/test/fileUp1",method=RequestMethod.POST)
	public void fileUpload1(String name, MultipartHttpServletRequest request) throws Exception{ //요 request로 일단 가지고 와서
		
		MultipartFile f = request.getFile("f1"); //파라미터 f1에 담겨있는 파일의 multipart file을 먼저 꺼내줘야해
		
		System.out.println("name:"+name);
		System.out.println("file:"+f.getName()); //파라미터 이름
		System.out.println("OriginalFile:"+f.getOriginalFilename());
		System.out.println("Size:"+f.getSize());
		
		//request.getRealPath("resources/upload"); //실제 경로를 꺼내와야하는데 request에서 꺼내면되지 (권장안하는방법)
		
		String path = request.getSession().getServletContext().getRealPath("resources/upload");
		
		this.upload1(f, path);
	}
	
	
	//파일을 디스크에 저장하는 메소드
	private String upload1(MultipartFile f,String path) throws Exception{
		
		String realPath = path; // 실제 경로 들고오기
		System.out.println(path);
		String fileName = UUID.randomUUID().toString(); //중복되는 이름이 없도록 랜덤하게 이름을 만들어주는 놈이야
		System.out.println(fileName);
		
		fileName=fileName+"_"+f.getOriginalFilename(); //랜덤이름_진짜이름.jpg
		
		File file = new File(path,fileName); //parent는 경로, child는 파일명
		
		//저장
		FileCopyUtils.copy(f.getBytes(),file);  //spring에서 제공하는 저장하는 클래스
		//앞에가 꺼내는 데이터 그대로 넣는다는 뜻이고 고거를 file에다가 보내겠다. file이 보내는 위치
		
		return fileName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
