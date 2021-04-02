package com.iu.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;
import com.iu.s3.board.notice.NoticeDAO;
import com.iu.s3.board.notice.NoticeDTO;
import com.iu.s3.member.MemberDTO;

public class NoticeDAOTest extends MyAbstractTest{
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getTotalTest() throws Exception{
//		long num = noticeDAO.getTotalCount();
//		assertNotNull(num);
//	}
	
//	//@Test
//	public void getListTest()throws Exception{
//		
//		List<NoticeDTO> ar=noticeDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
	
	//@Test
	public void getSelectTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		noticeDTO=noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	//@Test
	public void setInsertTest() throws Exception{
		for(int i =0; i<120; i++) {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("오즈의 마법사"+i);
		noticeDTO.setContents("너무 좋아!!"+i);
		noticeDTO.setWriter("관리자"+i);
		int result =noticeDAO.setInsert(noticeDTO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
	}
	
	//@Test
	public void setUpdateTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("오즈의 마법사");
		noticeDTO.setContents("너무 좋아!! 너무 재밌어 마저 읽고 싶다");
		noticeDTO.setNum(5);
		int result = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void setDeleteTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(5);
		int result = noticeDAO.setDelete(noticeDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void setHitUpdate() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		noticeDTO.setHit( noticeDTO.getHit()+1);
		int result=noticeDAO.setHitUpdate(noticeDTO);
		assertEquals(1, result);
	}
}
