package com.iu.s3.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;
import com.iu.s3.util.Pager_backUp;

public class BankBookDAOTest extends MyAbstractTest{

	@Autowired
	private BankBookDAO bankBookDAO;

	@Test
	public void setAdd() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		for(int i = 0; i<200; i++) {
			bankBookDTO.setBookName("BookName"+i);
			bankBookDTO.setRate(0.12);
			bankBookDTO.setSal("Y");
			int result = bankBookDAO.setAdd(bankBookDTO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		System.out.println("fin");
		//assertEquals(1, result);//희망하는 숫자, 진짜 나올 결과
	}

	//@Test
	public void getSelect() throws Exception{

		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(1);
		bankBookDTO=bankBookDAO.getSelect(bankBookDTO);//1번으로 조회하게 되어있으니까
		assertNotNull(bankBookDTO);//단정문,, 단언문,,
	}

	//@Test
	public void getList() throws Exception{
		Pager_backUp pager = new Pager_backUp();
		pager.setCurPage(1);
		List<BankBookDTO> ar =bankBookDAO.getList(pager);
		assertNotEquals(0, ar.size());

	}

	//@Test
	public void getDelete() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(7);
		int result = bankBookDAO.setDelete(bankBookDTO);
		assertEquals(1, result);
	}
	//@Test
	public void setUpdate() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(5);
		//조회먼저 해야함
		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
		//그리고 수정하고 싶은 데이터만 수정하기 왜냐면 내가 바꾼 거 이외에는 조회한 기본 데이터가 들어가게 되니까!! 

		bankBookDTO.setSal("Y");
		int result = bankBookDAO.setUpdate(bankBookDTO);
		assertEquals(1, result);

	}
}
