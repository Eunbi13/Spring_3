package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardFileDTO;
import com.iu.s3.board.BoardService;
import com.iu.s3.util.FileManager;
import com.iu.s3.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private HttpSession session;
	
	
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
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files)throws Exception{
		
		
		
		
		int result = noticeDAO.setInsert(boardDTO); 
		
		
	
		//파일들을 hdd저장, 가져오기 
		for(MultipartFile mf: files) {
			BoardFileDTO boardFileDTO= new BoardFileDTO();
			
			String fileName=fileManager.save("notice", mf, session);
			
			boardFileDTO.setNum(boardDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOrigineName(mf.getOriginalFilename());
			
			noticeDAO.setFileInsert(boardFileDTO);
		}
		
		
		
		return result;
	}
	
	
	//글수정
	public int setUpdate(BoardDTO boardDTO)throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}
	//글 삭제
	public int setDelete(BoardDTO boardDTO)throws Exception{
		
		List<BoardFileDTO> files = noticeDAO.getBoardFile(boardDTO);
		for(BoardFileDTO fileName : files) {
			boolean check=fileManager.delete("notice", session, fileName.getFileName());
			System.out.println(check);
			System.out.println(fileName.getOrigineName());
		}
		
		
		return noticeDAO.setDelete(boardDTO);
	}
	
	
}
