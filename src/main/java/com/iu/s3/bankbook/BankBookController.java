package com.iu.s3.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;



@Controller
public class BankBookController {
	@Autowired
	private BankBookService bankbookService;
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   리스트    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value = "/bankbook/bankbookList")
	public void getList(Model model) throws Exception{
//		ModelAndView modelAndView = new ModelAndView();
		
		List<BankBookDTO> ar =bankbookService.getList();
		
		model.addAttribute("list", ar);
		model.addAttribute("kind", "Bankbook");
//		modelAndView.setViewName("bankbook/bankbookList"); void로 할거니까 따로 담을 필요가 없잖아 그래서 그냥 모델을 매겨변수로 받아와서 하는거지 ㅇㅇ
		//뷰네임 안적어도 되긴한데 혹시 모르니까 걍 적어라 ㅇㅇ
//		return modelAndView;
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    상세 정보    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value= "/bankbook/bankbookSelect")
	public ModelAndView getSelect(BankBookDTO bankBookDTO, ModelAndView modelAndView /* , Model model 써도 됨 왜냐면 viewName을 쓸 필요가 없으니까*/) throws Exception{
		//ModelAndView modelAndView = new ModelAndView();
		
		bankBookDTO=bankbookService.getSelect(bankBookDTO);
		modelAndView.addObject("select",bankBookDTO);
		modelAndView.setViewName("bankbook/bankbookSelect");
				
		return modelAndView;
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   더하기    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value = "/bankbook/bankbookAdd")
	public void setAdd() throws Exception{
		
	}
	
	@RequestMapping(value = "/bankbook/bankbookAdd", method=RequestMethod.POST)
	public ModelAndView setAdd(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception{
		
		
		int result = bankbookService.setAdd(bankBookDTO);
		System.out.println("Add: "+result);
		
		modelAndView.setViewName("redirect:./bankbookList");//여기가 상대주소가 아니면 컨텍스트 네임부터 쓰는 절대 경로가 필요함 =>둘 다 쓸수 있긴 함 
		// 절대 경로 /abc
		//상대경로 ./abc
		//상대경로 ../abc
		//상대경로 abc 
		//절대경로는 localhost/절대경로 순으로 나오기 때문에 내가 redirect: /bankbook/bankbookList를 친다면 localhost/bankbook/bankbookList가 되어서 404가 나오는거임
		//이와 같은 계열로 상대경로를 생각해보자 ./bankbookList와 bankbookList는 상대경로이고 
		//내가 bankbook/bankbookList를 친다면 다시 보내는 redirect가 지금 bankbook폴더 내에 있기 때문에 /localhost/s1/bankbook/bankbook/bankbookList가 뜨는거임 
		return modelAndView; 
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    업데이트    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value = "/bankbook/bankbookUpdate")
	public void setUpdate() throws Exception{
		
	}
	
	@RequestMapping(value = "/bankbook/bankbookUpdate", method = RequestMethod.POST)
	public ModelAndView setUpdate(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		bankBookDTO.setBookNum(bankBookDTO.getBookNum());
		
		int result = bankbookService.setUpdate(bankBookDTO);
		System.out.println("Update: "+result);
		modelAndView.setViewName("redirect: bankbookList");
		
		return modelAndView;
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    삭제    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value = "/bankbook/bankbookDelete")
	public ModelAndView setDelete(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect: bankbookList");
		
		return modelAndView;
	}
	
	
	
}
