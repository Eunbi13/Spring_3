package com.iu.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;
import com.iu.s3.member.MemberDTO;

public class NoticeDAOTest extends MyAbstractTest{
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	//@Test
	public void getListTest()throws Exception{
		List<NoticeDTO> ar=noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void getSelectTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		noticeDTO=noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	//@Test
	public void setInsertTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("오즈의 마법사");
		noticeDTO.setContents("너무 좋아!!");
		noticeDTO.setWriter("관리자");
		int result =noticeDAO.setInsert(noticeDTO);
		assertEquals(1, result);
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
	
	@Test
	public void setHitUpdate() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		noticeDTO.setHit( noticeDTO.getHit()+1);
		int result=noticeDAO.setHitUpdate(noticeDTO);
		assertEquals(1, result);
	}
}
