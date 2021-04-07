package com.iu.s3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//최종 정리 버전 
	public void save(String name, MultipartFile multipartFile, HttpSession session)throws Exception{
		//어느폴더명에 넣을지 필요한 name
		//1.저장할 폴더 지정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		System.out.println(path);
		
		File file = new File(path);

		System.out.println(file.exists());
		if(!file.exists()){
			file.mkdirs();
		}
		//2.저장할 파일명
		String fileName ="";
		
//		Calendar ca = Calendar.getInstance();
//		long time = ca.getTimeInMillis();
//		fileName = time+"_"+multipartFile.getOriginalFilename();
		
		fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		//3.HDD에 저장
		file = new File(file, fileName);//file은 경로가 담긴 변수이고 fileName은 이름이 담긴 변수 이 둘로 파일변수를 하나 생성
//		FileCopyUtils.copy(multipartFile.getBytes(), file);//저 이진데이터랑 파일을 이용해서 새로운 파일로 카피
		multipartFile.transferTo(file);//그걸 작업하겠다. 
	}

	public File makePath(HttpSession session) throws Exception{
		
		//1.저장할 폴더 지정 resources/upload/member 
		//2.os에서 사용하는 인식할 수 있는 실제 경로 얘 입장에서는 c:가 루트이고
		//이거 쓸려면 섹션 등 내장 객체가 필요함 
		//어플리케이션 객체가 os와 연결하는 애라고 함 
		//jsp: application - server: ServletContext session에서 어플리케이션을 꺼내고 리퀘스트에서 섹션 꺼내고
		String path = session.getServletContext().getRealPath("resources/upload/member");
		System.out.println(path);
		
		//3.우리가 만든 파일이 잇을수도있고 없을 수도 있다고,,,그래서 폴더가 실제경로에 없으면 파일저장시 에러가 발생함
		//그래서 자동으로 만들어줄거임,,,와,,,이거,,,,
		File file = new File(path);

		System.out.println(file.exists());//존재하는지? 묻는 메서드
		if(!file.exists()){
			file.mkdirs();//없으면 만들겠다. 
		}
		
		//=====경로 만들었고 리턴하자 =======
		return file;
	}
	
	//4. 저장할  파일 이름 설정하려고 함 
	//왜?회원가입할 때 올려주는 폴더가 맴버 폴더인데 어떤 사람이 가입하면서 a.jpg올렸는데 다른 사람도 a.jpg올려버림,,,
	//그래서 시간이나 uuid 사용할거임 
	//이건 시간버전이고
	public String makeTimeFileName()throws Exception{
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		return String.valueOf(time);
	}
	//이번 uuid버전 골라쓸 수 잇도록 ㅇㅇ
	public String makeUUIDFileName()throws Exception{
		return UUID.randomUUID().toString();
	}
	
	//5.저장하는 방법 첫번째 
	public void saveUseCopy(MultipartFile multipartFile, File file) throws Exception{
		FileCopyUtils.copy(multipartFile.getBytes(), file);
	}
	//두번째
	public void saveUseTransfer(MultipartFile multipartFile, File file)throws Exception{
		multipartFile.transferTo(file);
	}
}
