package com.iu.s3.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s3.board.BoardDAO;
import com.iu.s3.board.BoardDTO;
import com.iu.s3.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s3.board.notice.NoticeDAO.";
	//리스트
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	
	
	
	public long getTotalCount(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	

	//셀렉트
	public NoticeDTO getSelect(BoardDTO boardDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardDTO);
	}
	//추가
	public int setInsert(BoardDTO boardDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}
	//업데이트
	public int setUpdate(BoardDTO boardDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	//삭제
	public int setDelete(BoardDTO boardDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	//hit업데이트
	public int setHitUpdate(BoardDTO boardDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setHitUpdate", boardDTO);
	}
	
	
	
}
