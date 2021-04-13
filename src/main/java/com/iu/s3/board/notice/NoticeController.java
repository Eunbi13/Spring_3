package com.iu.s3.board.notice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardFileDTO;
import com.iu.s3.member.MemberDTO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.Pager_backUp;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@PostMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName)throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean result = noticeService.setSummerFileDelete(fileName);
		System.out.println(result);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile file)throws Exception{
		String fileName = noticeService.setSummerFileUpload(file);
		//경로명도 만들겠다 ajax success로 갈 ㅇㅇ 파일 선택도 해줘야 뭐 갖다 주는지 알거고,,
		fileName="../resources/upload/notice/"+fileName;
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	
	
	
	
	
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
	public ModelAndView setUpdate(BoardDTO boardDTO, HttpSession session, MultipartFile [] files, ModelAndView mv)throws Exception{	
	
		System.out.println("noticeUpdate--");
		System.out.println(files.length);
		int result =noticeService.setUpdate(boardDTO, files);
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
	
	//@file 삭제
	@GetMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFileDTO boardFileDTO)throws Exception{
		int result = noticeService.setFileDelete(boardFileDTO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		//왜인가? 요청은 자바스크립트 내에서 발생함 응답이 와야하는데 요청한 곳으로 응답이 옴,, 자바스크립트에서 에이작스에서 요청이 하면
		//리절트라는 곳에서 받을거임(success: function(result))여기 ㅇㅇ
		//요청이 url로 발생하고 응답을 받아야 하는데 여기 들어오는 데이터는 뭐일지 모르는데,, 받아서 하려고 하는건 삭제가 되었는지 아닌지 알고 싶음
		//
		//요청한데로 보내는데,, 왜 에이작스로 가냐고,,, 기본 구조는  
		return mv;
	}
	
	
}
