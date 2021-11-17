package com.kh.workPeople.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

	@GetMapping("/login")
	public String login() {
		return "account/login/login";
	}
	
	@GetMapping("/manager-login")
	public String mangerLogin() {
		return "account/login/login_manager";
	}
	
	@GetMapping("/join/personal-join")
	public String personalJoin() {
		return "account/join/personalJoin";
	}
	
	@GetMapping("/join/company-join")
	public String companyJoin() {
		return "account/join/companyJoin";
	}
	
	@GetMapping("/changePassword")
	public String changePassword() {
		return "account/join/change_password";
	}
	
	@RequestMapping(value={"/findIdPwd/", "/findIdPwd/main"})
	public String findIdPwdMain() {
		return "account/findIdPwd/main";
	}
	
	@GetMapping("/findIdPwd/personal/findId")
	public String personalFindId(Model model) {
		model.addAttribute("member_type", "personal");

		return "account/findIdPwd/findId";
	}
	
	@GetMapping("/findIdPwd/personal/findPwd")
	public String personalFindPwd(Model model) {
		model.addAttribute("member_type", "personal");

		return "account/findIdPwd/findPwd";
	}
	
	@GetMapping("/findIdPwd/company/findId")
	public String companyFindId(Model model) {
		model.addAttribute("member_type", "company");

		return "account/findIdPwd/findId";
	}
	
	@GetMapping("/findIdPwd/company/findPwd")
	public String companyFindPwd(Model model) {
		model.addAttribute("member_type", "company");

		return "account/findIdPwd/findPwd";
	}
}
