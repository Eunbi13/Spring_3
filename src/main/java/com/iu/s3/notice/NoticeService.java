package com.iu.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s3.member.MemberDTO;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	//리스트
	public List<NoticeDTO> getList() throws Exception{
		return noticeDAO.getList();
	}
	//셀렉트
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception{//num2
		long num = noticeDTO.getHit();
			System.out.println(num);
			noticeDTO.setHit(num+1);//num2기준으로 dto를 꺼내는 그 중  hit+1 을 하고 다시 dto에 집어넣기 
			System.out.println(num+1);
		noticeDAO.setHitUpdate(noticeDTO);//업데이트 하고
		//조회를 해야겠지 업데이트 먼저 하고 조회하면 업데이트 된거까지 오를테니까,, 아니 왜 안오름?? 나중에 고치자,,
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		return noticeDTO;
	}
	//글 쓰기
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
