package com.kh.workPeople.account.login.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/account")
public class LoginController {

	@RequestMapping("/member/personal/login")
	public String login(HttpServletRequest request, RedirectAttributes rttr, Model model) {
		Map<String, String> redirectMap = (Map<String, String>) RequestContextUtils.getInputFlashMap(request);
		
		if(redirectMap != null) {
			rttr.addAttribute("id", redirectMap.get("id"));
			rttr.addAttribute("message", redirectMap.get("message"));
			rttr.addAttribute("loginRedirect", redirectMap.get("loginRedirect"));
		}
		
		model.addAttribute("type", "personal");
		
		return "account/login/login";
	}
	
	@RequestMapping("/member/company/login")
	public String companyLogin(HttpServletRequest request, RedirectAttributes rttr, Model model) { 
		Map<String, String> redirectMap = (Map<String, String>) RequestContextUtils.getInputFlashMap(request);
		
		if(redirectMap != null) {
			rttr.addAttribute("id", redirectMap.get("id"));
			rttr.addAttribute("message", redirectMap.get("message"));
			rttr.addAttribute("loginRedirect", redirectMap.get("loginRedirect"));
		}
		
		model.addAttribute("type", "company");
		
		return "account/login/login";
	}
	
	@RequestMapping("/manager/login")
	public String mangerLogin(HttpServletRequest request, RedirectAttributes rttr) {
		Map<String, String> redirectMap = (Map<String, String>) RequestContextUtils.getInputFlashMap(request);
		
		if(redirectMap != null) {
			rttr.addAttribute("id", redirectMap.get("id"));
			rttr.addAttribute("message", redirectMap.get("message"));
			rttr.addAttribute("loginRedirect", redirectMap.get("loginRedirect"));
		}
		
		return "account/login/login-manager";
	}

}
