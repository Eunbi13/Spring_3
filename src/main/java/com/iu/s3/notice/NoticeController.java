package com.iu.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.s3.member.MemberDTO;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	//리스트
	@RequestMapping("noticeList")
	public void getList(Model model)throws Exception{
		List<NoticeDTO> ar =  noticeService.getList();
		model.addAttribute("noticeList", ar); 
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
	public String setInsert(NoticeDTO noticeDTO, HttpSession session)throws Exception{
		noticeDTO.setWriter(((MemberDTO)session.getAttribute("member")).getId());
		System.out.println("글쓰는 id: "+((MemberDTO)session.getAttribute("member")));
		noticeService.setInsert(noticeDTO);
		return "redirect:./noticeList";
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
