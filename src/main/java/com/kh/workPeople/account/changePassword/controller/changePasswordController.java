package com.kh.workPeople.account.changePassword.controller;

import java.net.http.HttpClient.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.account.changePassword.model.service.ChangePasswordService;
import com.kh.workPeople.common.vo.MemberImpl;

@Controller
@RequestMapping("/account/member")
public class changePasswordController {
	
	@Autowired
	private ChangePasswordService changePasswordService;

	@GetMapping("/change-password")
	public String changePassword() {
		return "account/change-password/change-password";
	}
	
	@PostMapping("/change-password")
	public String updatePassword(@AuthenticationPrincipal MemberImpl memberImpl, String password, RedirectAttributes rttr) {
		int result = changePasswordService.changePassword(memberImpl, password);
		
		if(result > 0) {
			return "redirect:/";
		} else {
			rttr.addFlashAttribute("message", "비밀번호 변경에 실패하였습니다.");
			return "redirect:/common/errorPage";
		}
	}
	
}
