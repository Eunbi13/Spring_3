package com.iu.s3.member;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s3.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;

	public int memberJoin(MemberDTO memberDTO, MultipartFile avatar, HttpSession session)throws Exception{
		String fileName = fileManager.save("member", avatar, session);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setOrigineName(avatar.getOriginalFilename());
		memberFileDTO.setFileName(fileName);

		int result = memberDAO.memberJoin(memberDTO);
		result = memberDAO.setFileInsert(memberFileDTO);
		return result;
	}
	//로그인
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}

	//탈퇴
	public int memberDelete(MemberDTO memberDTO, HttpSession session) throws Exception{

		//아이디를 알고잇는데 그 아이디가 알고 잇는 파일을 찾아가야하잖음 fk로 있음 ㅇㅇ 파일네임을 알아야함 아이디로 조회할거임
		MemberFileDTO memberFileDTO=memberDAO.getMemberFile(memberDTO);
		boolean check = fileManager.delete("member", session, memberFileDTO.getFileName()) ;
		System.out.println(check);
		return memberDAO.memberDelete(memberDTO);
	}
	//수정
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
}
