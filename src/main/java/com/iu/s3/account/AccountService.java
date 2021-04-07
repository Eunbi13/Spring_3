package com.iu.s3.account;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public List<AccountDTO> getList(AccountDTO accountDTO)throws Exception{
		return accountDAO.getList(accountDTO);
	}
	
	public AccountDTO getSelect(AccountDTO accountDTO) throws Exception{
		return accountDAO.getSelect(accountDTO);
	}
	//아이디랑 북넘버 받아왔고 날짜는 데이터베이스가 만들어주고 남은건 밸런스랑 계정번호
	public int setInsert(AccountDTO accountDTO)throws Exception{
		//1.random nono
		//2.time
		//3.java API
		Calendar ca = Calendar.getInstance(); 
		long time = ca.getTimeInMillis();//1616719756621 식으로 나옴
		System.out.println(time);
		//1번방법
		String t = time+"";
		//2번방법
		t= String.valueOf(time);//String인건 static이라서 
		
		String result = t.substring(0, 3)+"-"+accountDTO.getBookNum()+"-"+t.substring(7,12);
		System.out.println(result);
		/*
		 * //SimpleDataFormat SimpleDateFormat format = new
		 * SimpleDateFormat("ddyyyyMM-HHmmss-S"); String r =
		 * format.format(ca.getTime()); System.out.println(r);
		 */
		accountDTO.setAccountNum(result);
		
		return accountDAO.setInsert(accountDTO);
	}
	
}
