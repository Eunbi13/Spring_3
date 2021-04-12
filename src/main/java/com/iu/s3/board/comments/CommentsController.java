package com.iu.s3.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comments/**")//디스패처 입장에서 상대주소로 주면 어쩌라고 느낌 그래서 절대주소 쓰는거 
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping("commentsDelete")
	public String setDelete(int [] commentNum)throws Exception{//CommentsDTO [] 로는 못받는다 왜냐? 넘어오는게 int라서 타입이 x
		//여러개 삭제하는 건 서비스에서 하는 것
		int result = commentsService.setDelete(commentNum);
		System.out.println("controller"+result);
		return "comments/commentsList";
	}
	
	
	@GetMapping("commentsList")
	public void getList(CommentsDTO commentsDTO, Model model)throws Exception{
		List<CommentsDTO> list=commentsService.getList(commentsDTO);
		model.addAttribute("list", list);
		System.out.println(list.get(0).getRegDate());
		System.out.println(commentsDTO.getNum());
	}
	
	@PostMapping("commentsInsert")
	public ModelAndView setInsert(CommentsDTO commentsDTO)throws Exception{
		System.out.println(commentsDTO.getWriter());
		System.out.println(commentsDTO.getContents());
		ModelAndView mv = new ModelAndView();
		int result=commentsService.setInsert(commentsDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
}
