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
	
	@RequestMapping(value={"/find-id-pwd/", "/find-id-pwd/main"})
	public String findIdPwdMain() {
		return "account/find-id-pwd/main";
	}
	
	@GetMapping("/find-id-pwd/personal/find-id")
	public String personalFindId(Model model) {
		model.addAttribute("member_type", "personal");

		return "account/find-id-pwd/find-id";
	}
	
	@GetMapping("/find-id-pwd/personal/find-pwd")
	public String personalFindPwd(Model model) {
		model.addAttribute("member_type", "personal");

		return "account/find-id-pwd/find-pwd";
	}
	
	@GetMapping("/find-id-pwd/company/find-id")
	public String companyFindId(Model model) {
		model.addAttribute("member_type", "company");

		return "account/find-id-pwd/find-id";
	}
	
	@GetMapping("/find-id-pwd/company/find-pwd")
	public String companyFindPwd(Model model) {
		model.addAttribute("member_type", "company");

		return "account/find-id-pwd/find-pwd";
	}
}
