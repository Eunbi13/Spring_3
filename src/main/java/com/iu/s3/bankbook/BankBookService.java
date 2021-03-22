package com.iu.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    리스트    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public List<BankBookDTO> getList() throws Exception{
	
//		List<BankBookDTO> ar=bankBookDAO.getList(); 이제 이거 안해도 되네,,
		
		return bankBookDAO.getList();
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    상세정보    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception{
		
//		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
		
		return bankBookDAO.getSelect(bankBookDTO);
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    정보 추가    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int setAdd(BankBookDTO bankBookDTO)throws Exception{
		int result = bankBookDAO.setAdd(bankBookDTO);
		return result;
	}
	
	
//업데이트@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookDAO.setUpdate(bankBookDTO);
		return result;
	}
	
	
	//삭제@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public void setDelete()throws Exception{
		
	}
	
}
