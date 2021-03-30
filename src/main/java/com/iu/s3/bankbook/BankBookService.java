package com.iu.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s3.util.Pager;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public List<BankBookDTO> getList(Pager pager) throws Exception{

		long perPage = 10;
		long perBlock = 5;
		//----startRow, lastRow---
		long startRow = (pager.getCurPage()-1)*perPage+1;
		long lastRow = pager.getCurPage()*perPage;
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		//1 totalCount구해오기
		long totalCount =bankBookDAO.getTotalCount(pager);
		//2. totalPage 구하기
		long totalPage = totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		//3. totalBlock계산
		long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		//4. curBlock 계산
		long curBlock = pager.getCurPage()/perBlock;
		if(pager.getCurPage()%perBlock !=0) {
			curBlock++;
		}
		//5. startNum, lastNum
		long startNum=(curBlock-1)*perBlock+1;
		long lastNum=curBlock*perBlock;
		
		//6. curBlock이 마지막 Block일때 (totalBlock일떄
		if(curBlock==totalBlock) {
			lastNum=totalPage;
		}
		//7. 이전 다음 block의 존재여부 블리언 타입이고 자동으로 false초기화
		if(curBlock!=1) {
			pager.setPre(true);
		}
		if(curBlock!=totalBlock) {
			pager.setNext(true);
		}
		
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		
		System.out.println("totalPage"+totalPage);
		System.out.println("totalBlock"+totalBlock);
		System.out.println("curBlock"+curBlock);
		return bankBookDAO.getList(pager);
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception{//클라이언트가 넘겨주는 데이터가 BankBookDTO인 것
		return bankBookDAO.getSelect(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setDelete(bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
}
