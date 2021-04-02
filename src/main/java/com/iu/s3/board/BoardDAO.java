package com.iu.s3.board;

import java.util.List;

import com.iu.s3.util.Pager;

public interface BoardDAO {
	//상수와 추상메서드만 가질 수 있다. 
	//접근 지정자는 무조건 public이여야 하고 추상 메서드니까 abstract이 들어가야함
	//근데 생략도 가능함 ㅎㅋ
	
	//이름을 통일시키고자 함 
	//list NoticeDTO -> BoardDTO상속 QnaDTO -> BoardDTO상속
	public abstract List<BoardDTO> getList(Pager pager)throws Exception;

	//전체 글의 갯수
	public long getTotalCount(Pager pager)throws Exception;
	
	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO)throws Exception;
	
	//hit update
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;

	//글 추가
	public int setInsert(BoardDTO boardDTO)throws Exception;
	
	//글 삭제 
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
}
