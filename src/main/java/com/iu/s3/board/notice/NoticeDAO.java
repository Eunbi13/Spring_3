package com.iu.s3.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s3.board.BoardDAO;
import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardFileDTO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.Pager_backUp;

@Repository
public class NoticeDAO implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s3.board.notice.NoticeDAO.";
	//===============List==================	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public long getTotalCount(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	//===============select==================	
	public NoticeDTO getSelect(BoardDTO boardDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardDTO);
	}
	//hit업데이트
	public int setHitUpdate(BoardDTO boardDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setHitUpdate", boardDTO);
	}

	//=============================insert===========================
	public int setInsert(BoardDTO boardDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}
	
	//파일추가
	public int setFileInsert(BoardFileDTO boardfileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileInsert", boardfileDTO);
	}
	
	//=============================Update==========================
	public int setUpdate(BoardDTO boardDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	//=============================delete===========================
	public int setDelete(BoardDTO boardDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	

	public List<BoardFileDTO> getBoardFile(BoardDTO boardDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getBoardFile", boardDTO);
	}
	
	
	
	
	
	
}
