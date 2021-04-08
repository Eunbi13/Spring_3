package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.member.MemberDTO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.Pager_backUp;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	//리스트
	@RequestMapping(value="noticeList")
	public ModelAndView getList(Pager pager /* @RequestParam(defaultValue = "1") long curPage */)throws Exception{
	
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar =  noticeService.getList(pager);
		mv.addObject("list", ar); 
		mv.addObject("board","notice");
		mv.setViewName("board/boardList");
		mv.addObject("pager", pager);//아 이거 여러개 넣을 수 있구나
		return mv;
	}
	// ---셀렉트-----------------셀렉트--------------------셀렉트--------------셀렉트---------------------
	@RequestMapping("noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDTO)throws Exception{
		NoticeDTO noticeDTO = noticeService.getSelect(boardDTO);
		ModelAndView mv= new ModelAndView();
		mv.addObject("dto", noticeDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	//글 쓰기 get----------------------------------------------------------
	@RequestMapping("noticeInsert")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board","notice");
		return mv;
	}
	//글쓰기 post
	@RequestMapping(value="noticeInsert", method = RequestMethod.POST)
	public String setInsert(NoticeDTO noticeDTO, HttpSession session, Model model, MultipartFile [] files)throws Exception{
		noticeDTO.setWriter(((MemberDTO)session.getAttribute("member")).getId());
		
		int result = noticeService.setInsert(noticeDTO, files);
		
		String message = "잘 못 입력하셨습니다.";
		String path = "./noticeInsert";
		if(result>0) {
			message = "글이 정상적으로 등록 되었습니다.";
			path = "./noticeList";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		return "common/commonResult";
	}
	
	
	//글 수정get
	@RequestMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("--noticUpdate");
		
		boardDTO=noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	//글 수정 post
	@RequestMapping(value="noticeUpdate", method = RequestMethod.POST)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{	
	
		System.out.println("noticeUpdate--");
		
		int result =noticeService.setUpdate(boardDTO);
		//성공하면 리스트 실패하면 alert창 하고 리스트로 이동
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg","Failed");
			mv.addObject("path","./noticeList");
			mv.setViewName("common/commonResult");
		}
		
		return mv;
	}
	
	
	
	//글 삭제 
	@PostMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		String message="failed";
		String path="./noticeList";
		if(result>0) {
			message="succes";
		}
		mv.addObject("msg",message);
		mv.addObject("path",path);
		mv.setViewName("common/commonResult");
		
		return mv;
	}
	
}
