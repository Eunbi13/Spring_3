package com.iu.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/**")//bankbook으로 시작하는 모든 요청(하위폴더 포함)은 이 클래스로 받겠다.
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	
	//위에 있는 RequestMapping+value
	@RequestMapping("bankbookList")//속성이 value 하나라면 생략 가능
	public void getList(Model model) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList(); 
		//jsp경로명, model
		model.addAttribute("list",ar);//void를 사용함으로서 view는 mapping에 적어둔 링크를 자동으로 따라감 그래서 우리는 modelandview에서 model만 사용하게 됨
	}
	
	@RequestMapping(value = "bankbookSelect", method = RequestMethod.GET)
	public ModelAndView getSelect(BankBookDTO bankBookDTO) throws Exception{//파라미터의 이름과 DTO의 이름이 동일해야 함을 잊지 말기
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", bankBookDTO);
		modelAndView.setViewName("bankbook/bankbookSelect");//얘는mapping value와 관계 없다 얘는 내가 포워딩 하는 주소이니까 앞에 폴더명도 적어줘야하는 거임
		//모델앤뷰는 servletcontext로 가는거임 그래서 위와 같이 적는거고 즉 얘는 경로의 완전체가 아니라고!!
		return modelAndView;
	}
	
	@RequestMapping("bankbookDelete")
	public String setDelete(BankBookDTO bankBookDTO) throws Exception{
		System.out.println("Delete실행");
		int result= bankBookService.setDelete(bankBookDTO);
		System.out.println(result);
		
		//jsp로 가는게 아니고 url을 클라이언트에게 보내고 클라이언트가 다시 컨트롤러에게 요청하고 view가 나타나는 방식 클라이언트에게 가는 거니까 상대경로 필요
		return "redirect:./bankbookList";
		//얘는 그냥 바로 클라이언트로 가버림 그리서 상대경로가 필요한거임
	}
	
	@RequestMapping(value="bankbookUpdate")
	public void setUpdate(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		
		model.addAttribute("dto", bankBookDTO);
	}
	
	@RequestMapping(value="bankbookUpdate", method = RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception{
		System.out.println("updatepost");
		int result = bankBookService.setUpdate(bankBookDTO);
		System.out.println(result);
		
		return "redirect:./bankbookList";
	}
	
	
}
