package com.iu.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("memberJoin")
	public void memberJoin()throws Exception{
		System.out.println("--join");
	}
	
	
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) throws Exception{
		System.out.println("join --");
		int result = memberService.memberJoin(memberDTO);
		System.out.println(result);
	
		
		return "redirect:../";
	}
	
	@RequestMapping("memberLogin")
	public void memberLogin()throws Exception{
		System.out.println("--login");
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO) throws Exception{
		System.out.println("login--");
		memberDTO=memberService.memberLogin(memberDTO);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:./memberLogin");
		//상대주소는 리다이렉트일때만 ! 포워드는 절대주소로@@@경로쓸때 url창도 잘 확인해보고,,,하자,,!아니 이건 근데 url창에도 /member/memberLogin으로 뜨더라구?? 그니까 걍 포워딩이 잘못된거같았음
		//,,,,,,나 뭐 적으려고했지,,? 포워딩하면 서블렛으로 가니까,,, 
		//즉 view를 통해서 데이터를 표기해야하면,,, view를 가야하니까 servlet을 가야해 그래서 "member/memberLogin"을 쓰는거고! 
		//리다이렉트를 할때는 데이터표기 x view x 니까 굳이 servlet작업을 할 필요가 없어. 때문에 지금 위치에서 바로 가버리자는 의미로 "redirect: ./memberLogin"을 쓰는구나!!
		if(memberDTO!=null) {
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getName());
		
		mv.addObject("login", memberDTO);
		
		
			mv.setViewName("redirect:../");
		}
	
		return mv;
	}
	
	
	
}
