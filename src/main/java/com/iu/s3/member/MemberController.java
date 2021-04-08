package com.iu.s3.member;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//로그아웃
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();//섹션의 유지 시간을 0으로 만들겠다. session id랑 데이터를 null로 바꿔버린거임
		return "redirect:../";
	}
	
	//마이페이지
	@RequestMapping(value="memberPage")
	public String memberPage() throws Exception{//session담을 필요 없었네,, 하긴 쓰지도 않는데 굳이? 
		return "./member/memberPage";
				
	}

	//탈퇴
	@RequestMapping(value="memberDelete")
	public String memberDelete(HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//invalidate하고 session에 담고 싶어도 해당 id가 없는 거 그니까 key가 없어졌다고 생각해도 될듯
		int num = memberService.memberDelete(memberDTO);//여기까진 DB를 지운것 session과는 독립적임
		System.out.println(num+"삭제 완료");
		session.invalidate();//session 종료, session데이터 삭제
		
		return "redirect: ../";
	}
	//수정
	@RequestMapping(value="memberUpdate")
	public void memberUpdqte()throws Exception{
		
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String memberUpdqte(MemberDTO memberDTO,HttpSession session)throws Exception{
		
		System.out.println(memberDTO.getPw());
		int num = memberService.memberUpdate(memberDTO);//DB업데이트
		System.out.println("update"+num);
		
		if(num>0) {
			
			memberDTO = memberService.memberLogin(memberDTO);
			session.setAttribute("member", memberDTO);//session에 같은 이름으로 덮어씌우기
		}
		return "redirect:../";
	}
	
	@RequestMapping("memberJoinCheck")
	public void memberJoinCheck() throws Exception{
		
	}
	
	@RequestMapping("memberJoin")
	public void memberJoin()throws Exception{
		System.out.println("--join");
	}


	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO, MultipartFile avatar, Model model, HttpSession session)throws Exception{
		System.out.println("join--");
		int result = memberService.memberJoin(memberDTO, avatar, session);
		System.out.println(avatar.getName());//파라미터명
		System.out.println(avatar.getOriginalFilename());//upload 할 때 파일명
		System.out.println(avatar.getSize());//파일의 크기(byte)
		System.out.println(avatar.isEmpty());//파일의 존재 유무
		
		
		String message="회원가입 실패";
		String path="./memberJoin";
		
		if(result>0) {
			message="회원가입 성공";
			path="../";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		return "common/commonResult";
		
	}

	@RequestMapping("memberLogin")
	public void memberLogin()throws Exception{
		System.out.println("--login");
	}

	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		System.out.println("login--");
		memberDTO = memberService.memberLogin(memberDTO);
	
		
		System.out.println(memberDTO);
		
		session.setAttribute("member", memberDTO);

//		mv.setViewName("redirect:./memberLogin");
//		//상대주소는 리다이렉트일때만 ! 포워드는 절대주소로@@@경로쓸때 url창도 잘 확인해보고,,,하자,,!아니 이건 근데 url창에도 /member/memberLogin으로 뜨더라구?? 그니까 걍 포워딩이 잘못된거같았음
//		//,,,,,,나 뭐 적으려고했지,,? 포워딩하면 서블렛으로 가니까,,, 
//		//즉 view를 통해서 데이터를 표기해야하면,,, view를 가야하니까 servlet을 가야해 그래서 "member/memberLogin"을 쓰는거고! 
//		//리다이렉트를 할때는 데이터표기 x view x 니까 굳이 servlet작업을 할 필요가 없어. 때문에 지금 위치에서 바로 가버리자는 의미로 "redirect: ./memberLogin"을 쓰는거!
//		if(memberDTO!=null) {
//			System.out.println(memberDTO.getId());
//			System.out.println(memberDTO.getName());
//
//			mv.addObject("dto", memberDTO);
//
//			mv.setViewName("home");
//		}

		return "redirect:../";
	}



}
