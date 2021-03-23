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

	@Test
	public void memberLogin() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("today");
		memberDTO.setPw("today");
		memberDTO=memberDAO.memberLogin(memberDTO);
		assertNotNull(memberDTO);
	}
	
	
}
