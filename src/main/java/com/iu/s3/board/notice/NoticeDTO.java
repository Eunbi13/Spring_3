package com.iu.s3.board.notice;

import java.util.List;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardFileDTO;

public class NoticeDTO extends BoardDTO{
	
	private List<BoardFileDTO> noticeFiles;

	public List<BoardFileDTO> getNoticeFiles() {
		return noticeFiles;
	}

	public void setNoticeFiles(List<BoardFileDTO> noticeFiles) {
		this.noticeFiles = noticeFiles;
	}

	
	
}
