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
