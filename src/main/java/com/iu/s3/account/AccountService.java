package com.iu.s3.account;

import java.util.List;
import java.util.Random;

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
		Random random = new Random();
		int preNum = random.nextInt(1000);
		int sufNum = random.nextInt(100000);
		accountDTO.setAccountNum(preNum+ "-"+accountDTO.getBookNum()+"-"+sufNum);
		accountDTO.setBalance(0);
		return accountDAO.setInsert(accountDTO);
	}
	
}
