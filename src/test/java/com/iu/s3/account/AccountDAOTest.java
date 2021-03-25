package com.iu.s3.account;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class AccountDAOTest extends MyAbstractTest{
	@Autowired
	private AccountDAO accountDAO;
	
	//@Test
	public void getList()throws Exception {
		AccountDTO accountDTO = new  AccountDTO();
		accountDTO.setId("lay");
		List<AccountDTO> ar=accountDAO.getList(accountDTO);
		assertNotEquals(0, ar.size());
	}
		
	@Test
	public void getSelect() throws Exception{
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNum("111-3-11111");
		accountDAO.getSelect(accountDTO);
		assertNotNull(accountDTO);
	}
	
	
	//@Test
	public void setInsert()throws Exception{
		AccountDTO accountDTO = new  AccountDTO();
		accountDTO.setId("today");
		accountDTO.setAccountNum("444-3-44444");
		accountDTO.setBookNum(3);
		accountDTO.setBalance(0);
		int result=accountDAO.setInsert(accountDTO);
		assertEquals(1, result);
	}
		

}
