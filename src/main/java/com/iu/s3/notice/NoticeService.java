package com.iu.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s3.member.MemberDTO;
import com.iu.s3.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	//리스트
	public List<NoticeDTO> getList(Pager pager) throws Exception{
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
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception{//num2
		noticeDTO = noticeDAO.getSelect(noticeDTO);//조회를 하고,, 여기서 숫자를 빼야했어.
		long num = noticeDTO.getHit()+1;//그럼 여기서 조회된 데이터hit에 +1을 하고 
		System.out.println(num);
		noticeDTO.setHit(num);//다시 그 숫자로 데이터hit에 넣고 
		noticeDAO.setHitUpdate(noticeDTO);//업데이트 하기
		//그리고 다시 조회,,
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		return noticeDTO;
	}
	//글 쓰기-------------------------------------------------------
	public int setInsert(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.setInsert(noticeDTO);
	}
	//글수정
	public int setUpdate(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.setUpdate(noticeDTO);
	}
	//글 삭제
	public int setDelete(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.setDelete(noticeDTO);
	}
	
	
}
