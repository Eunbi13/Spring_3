package com.iu.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class memberDAOTest extends MyAbstractTest {
	
	@Autowired
	private MemberDAO memberDAO; 
	
	//@Test
	public void memberJoin() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("today");
		memberDTO.setPw("today");
		memberDTO.setName("today");
		memberDTO.setPhone("01000000088");
		memberDTO.setEmail("today@Tuesday");
		int result = memberDAO.memberJoin(memberDTO);
		assertEquals(1, result);
		
	}

	//@Test
	public void memberLogin() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("today");
		memberDTO.setPw("today");
		memberDTO=memberDAO.memberLogin(memberDTO);
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void memberDelete() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("q");
		int result = memberDAO.memberDelete(memberDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void memberUpdate() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("tomorrow");
		memberDTO.setPw("tomorrow");
		memberDTO=memberDAO.memberLogin(memberDTO);
		memberDTO.setEmail("tomorrow@together");
		memberDTO.setPhone("01044444444");
		int result = memberDAO.memberUpdate(memberDTO);
		assertEquals(1, result);
	}
	
	
}
