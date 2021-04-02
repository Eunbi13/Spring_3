package com.iu.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")//get임년 이거,,, 포스트묜 postmapping
	public ModelAndView getList(Pager pager)throws Exception{
		List<BoardDTO> ar=qnaService.getList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board", "qna");
		return mv;
	}
	
	@GetMapping("qnaInsert")
	public ModelAndView getInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "qna");
		return mv;
	}
	

}
