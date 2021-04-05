package com.iu.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")//get이면 이거,,, 포스트면 postmapping
	public ModelAndView getList(Pager pager)throws Exception{
		List<BoardDTO> ar=qnaService.getList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board", "qna");
		return mv;
	}
	@GetMapping("qnaSelect")
	public ModelAndView getSelect(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
			QnaDTO qnaDTO = (QnaDTO)qnaService.getSelect(boardDTO);
			mv.addObject("dto", qnaDTO);
			mv.setViewName("board/boardSelect");
			mv.addObject("board", "qna");
		return mv;
	}
	
	@GetMapping("qnaInsert")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "qna");
		return mv;
	}
	@PostMapping("qnaInsert")
	public ModelAndView setInsert(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
			int result = qnaService.setInsert(boardDTO);
			mv.setViewName("redirect: ./qnaList");
		return mv;
	}
	
	//========reply========
	@GetMapping("qnaReply")
	public ModelAndView setReply()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");
		
		
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaService.setReply(qnaDTO);
		
		mv.setViewName("redirect: ./qnaList");
		
		return mv;
	}
	
	

}
