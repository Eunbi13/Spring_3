package com.iu.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
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
		mv.addObject("pager", pager);
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
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files)throws Exception{
		ModelAndView mv = new ModelAndView();
			int result = qnaService.setInsert(boardDTO, files);
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
	
	
	//========Delete========
	@PostMapping("qnaDelete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		String message="Failed";
		String path="./qnaList";
		int result = qnaService.setDelete(boardDTO);
		if(result>0) {
			message="Succesed";
		}
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}
	
	//========Update=======
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardDTO = qnaService.getSelect(boardDTO);
		
		mv.setViewName("board/boardUpdate");
		mv.addObject("board","qna");
		mv.addObject("dto", boardDTO);
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		int result = qnaService.setUpdate(boardDTO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.setViewName("common/commonResult");
			mv.addObject("msg", "Failed");
			mv.addObject("path", "./qnaList");
		}
		
		
		
		return mv;
	}
}
