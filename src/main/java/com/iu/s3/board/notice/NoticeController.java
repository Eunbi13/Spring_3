package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.member.MemberDTO;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	//리스트
	@RequestMapping(value="noticeList")
	public ModelAndView getList(Pager pager /* @RequestParam(defaultValue = "1") long curPage */)throws Exception{
	
		ModelAndView mv = new ModelAndView();
		List<NoticeDTO> ar =  noticeService.getList(pager);
		mv.addObject("noticeList", ar); 
		mv.setViewName("notice/noticeList");
		mv.addObject("pager", pager);//아 이거 여러개 넣을 수 있구나
		return mv;
	}
	//셀렉트 
	@RequestMapping("noticeSelect")
	public void getSelect(NoticeDTO noticeDTO, Model model)throws Exception{
		noticeDTO = noticeService.getSelect(noticeDTO);
		
		model.addAttribute("dto", noticeDTO);
	}
	//글 쓰기 get----------------------------------------------------------
	@RequestMapping("noticeInsert")
	public void setInsert()throws Exception{
		
	}
	//글쓰기 post
	@RequestMapping(value="noticeInsert", method = RequestMethod.POST)
	public String setInsert(NoticeDTO noticeDTO, HttpSession session, Model model)throws Exception{
		noticeDTO.setWriter(((MemberDTO)session.getAttribute("member")).getId());
		System.out.println("글쓰는 id: "+((MemberDTO)session.getAttribute("member")));
		int result = noticeService.setInsert(noticeDTO);
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
	public void setUpdate(NoticeDTO noticeDTO, Model model)throws Exception{
		System.out.println("--noticUpdate");
		noticeDTO=noticeService.getSelect(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	//글 수정 post
	@RequestMapping(value="noticeUpdate", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO)throws Exception{		
		System.out.println("noticeUpdate--");
		noticeService.setUpdate(noticeDTO);
		return "redirect:./noticeSelect?num="+noticeDTO.getNum();
	}
	//글 삭제 get
	@RequestMapping("noticeDelete")
	public String setDelete(NoticeDTO noticeDTO)throws Exception{
		noticeService.setDelete(noticeDTO);
		return "redirect:./noticeList";
	}
	
}
