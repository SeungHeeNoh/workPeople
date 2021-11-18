package com.kh.workPeople.account.findIdPwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/find-id-pwd")
public class FindIdPwdController {

	@RequestMapping(value={"/", "/main"})
	public String findIdPwdMain() {
		return "account/find-id-pwd/main";
	}

	@GetMapping("/personal/find-id")
	public String personalFindId(Model model) {
		model.addAttribute("member_type", "personal");

		return "account/find-id-pwd/find-id";
	}
	
	@GetMapping("/personal/find-pwd")
	public String personalFindPwd(Model model) {
		model.addAttribute("member_type", "personal");

		return "account/find-id-pwd/find-pwd";
	}
	
	@GetMapping("/company/find-id")
	public String companyFindId(Model model) {
		model.addAttribute("member_type", "company");

		return "account/find-id-pwd/find-id";
	}
	
	@GetMapping("/company/find-pwd")
	public String companyFindPwd(Model model) {
		model.addAttribute("member_type", "company");

		return "account/find-id-pwd/find-pwd";
	}
}
