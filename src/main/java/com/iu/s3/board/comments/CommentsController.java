package com.iu.s3.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments/**")//디스패처 입장에서 상대주소로 주면 어쩌라고 느낌 그래서 절대주소 쓰는거 
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping("commentsInsert")
	public void setInsert(CommentsDTO commentsDTO)throws Exception{
		System.out.println(commentsDTO.getWriter());
		System.out.println(commentsDTO.getContents());
	}
	
	@GetMapping("commentsList")
	public void getList(CommentsDTO commentsDTO, Model model)throws Exception{
		List<CommentsDTO> list=commentsService.getList(commentsDTO);
		model.addAttribute("list", list);
		System.out.println(commentsDTO.getNum());
	}
}
