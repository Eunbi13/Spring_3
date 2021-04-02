package com.iu.s3.board;

import java.util.List;

import com.iu.s3.util.Pager;

public interface BoardService {
	//list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception; 
	
	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO)throws Exception;

	//글 추가
	public int setInsert(BoardDTO boardDTO)throws Exception;
	
	//글 삭제 
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
}
