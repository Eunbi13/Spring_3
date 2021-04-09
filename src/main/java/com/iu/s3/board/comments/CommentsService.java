package com.iu.s3.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
	@Autowired
	private CommentsDAO commentsDAO;
	
	public List<CommentsDTO> getList(CommentsDTO commentsDTO)throws Exception{
		return commentsDAO.getList(commentsDTO);
	}
}
