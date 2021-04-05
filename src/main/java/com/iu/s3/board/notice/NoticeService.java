package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardService;
import com.iu.s3.member.MemberDTO;
import com.iu.s3.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	//리스트\
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		int perPage=10;//한 페이지에 보여줄 글의 개수
		int perBlock=5;//한 블럭당 보여줄 숫자의 개수
		//----startRow, lastRow---
		long startRow=(pager.getCurPage()-1)*perPage+1;
		long lastRow=pager.getCurPage()*perPage;
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		//----
		//1 totalCount구해오기
		long totalCount=noticeDAO.getTotalCount(pager);
		//2. totalPage 구하기 (마지막 번호
		long totalPage=	totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		//3. totalBlock계산 (블록수 
		long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		//4. curBlock 계산
		long curBlock=pager.getCurPage()/perBlock;
		if(pager.getCurPage()%perBlock !=0) {
			curBlock++;
		}
		//5. startNum, lastNum
		long startNum = (curBlock-1)*perBlock+1;
		long lastNum= curBlock*perBlock;
		
		
		//6. curBlock이 마지막 Block일때 (totalBlock일떄
		if(curBlock==totalBlock) {
			lastNum=totalPage;
		}
		
		//7. 이전 다음 block의 존재여부
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
		return noticeDAO.getList(pager);
	}
	//셀렉트
	public NoticeDTO getSelect(BoardDTO boardDTO) throws Exception{//num2보드에 잇는 숫자로
	
		noticeDAO.setHitUpdate(boardDTO);//업데이트 하기 리턴으로 int나옴 그리고 이미 저장됨 +1되어서 
	
		
		return noticeDAO.getSelect(boardDTO);
	}
	//글 쓰기-------------------------------------------------------
	public int setInsert(BoardDTO boardDTO)throws Exception{
		return noticeDAO.setInsert(boardDTO);
	}
	
	
	//글수정
	public int setUpdate(BoardDTO boardDTO)throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}
	//글 삭제
	public int setDelete(BoardDTO boardDTO)throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}
	
	
}
