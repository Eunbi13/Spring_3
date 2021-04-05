package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardService;
import com.iu.s3.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	//리스트\
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRow();
		long totalCount=noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		
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
