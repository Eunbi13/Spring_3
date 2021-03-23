package com.iu.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class memberDAOTest extends MyAbstractTest {
	
	@Autowired
	private MemberDAO memberDAO; 
	
	@Test
	public void test() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDAO.memberJoin(memberDTO);
	}

}
