package com.iu.s3.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.member.MemberDTO;

@Controller
@RequestMapping(value="account/**")
public class AccountController {
	@Autowired
	private AccountService accountService;
//id따라 소유한 계정 보여주기
	@RequestMapping("accountList")
	public void getList(HttpSession session, Model model) throws Exception{	
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setId(((MemberDTO)session.getAttribute("member")).getId());
		//Mapper에서 parameterType을 MemberDTO 하던가 String타입으로 받는거도 괜찮다 
		
		List<AccountDTO> ar =accountService.getList(accountDTO);
		model.addAttribute("accountList", ar);
		
	}
	
	//계정 선택하면 상세 내역 보여줌
	@RequestMapping("accountSelect")
	public void getSelect(AccountDTO accountDTO, Model model)throws Exception{
		
		accountDTO=accountService.getSelect(accountDTO);
		model.addAttribute("accountSelect", accountDTO);
	}
	
	//계좌 개설(북셀렉트에서 번호 받아옴)
	@RequestMapping("accountInsert")
	public String setInsert(String bookNum, HttpSession session)throws Exception{
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setBookNum( Integer.parseInt(bookNum));
		//member session에서 아이디 빼서 어카운트로 이식시킴,,ㅎ
		accountDTO.setId(((MemberDTO)session.getAttribute("member")).getId());
		int result = accountService.setInsert(accountDTO);//여기까지 북넘버랑 아이디 담김
		System.out.println(result);
		
		
		return"redirect: ./accountList";
	}
	
	
	
}
