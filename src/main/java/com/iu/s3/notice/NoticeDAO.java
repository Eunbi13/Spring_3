package com.iu.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s3.notice.NoticeDAO.";
	//리스트
	public List<NoticeDTO> getList()throws Exception{
		List<NoticeDTO> ar = sqlSession.selectList(NAMESPACE+"getList");
		return ar;
	}
	//셀렉트
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", noticeDTO);
	}
	//추가
	public int setInsert(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setInsert", noticeDTO);
	}
	//업데이트
	public int setUpdate(NoticeDTO noticeDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
	}
	//삭제
	public int setDelete(NoticeDTO noticeDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
	}
	//hit업데이트
	public int setHitUpdate(NoticeDTO noticeDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setHitUpdate", noticeDTO);
	}
	
	
	
}
