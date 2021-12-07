package com.kh.workPeople.company.mypage.memberInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.company.mypage.memberInfo.service.MemberInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/company/mypage")
public class MemberInfoController {
	
	private MemberInfoService memberInfoService;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberInfoController(MemberInfoService memberInfoService, PasswordEncoder passwordEncoder) {
		this.memberInfoService = memberInfoService;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@GetMapping("/memberInfoPwd")
	public String memberPwd(Model model, @AuthenticationPrincipal MemberImpl user) {
		
		model.addAttribute("member", user);
		
		return "company/mypage/memberInfoPwd";
	}
	

	@GetMapping("/memberInfoUpdate")
	public String memberUpdate(Model model, @AuthenticationPrincipal MemberImpl user) {
		
		model.addAttribute("member", user);
		
		return "company/mypage/memberInfoUpdate";
	}
	
	@GetMapping("/memberleave")
	public String memberLeave(Model model, @AuthenticationPrincipal MemberImpl user) {
		
		model.addAttribute("member", user);
		
		return "company/mypage/memberleave";
	}
	
	@PostMapping("/memberleave")
	public String leave(@AuthenticationPrincipal MemberImpl user) {
		
		int result = memberInfoService.leave(user);
		
		return "redirect:/account/manager/logout";
	}
	
	@PostMapping("/pwdCheck")
	public String pwd(@RequestParam("password") String password, @AuthenticationPrincipal MemberImpl user, Model model, RedirectAttributes rttr) {
		
		log.info("비밀번호 확인 요청 발생!!");
		
		String result;
		
		if (passwordEncoder.matches(password, user.getPwd())) {
			result = "redirect:/company/mypage/memberInfoUpdate";
		} else {
			rttr.addFlashAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
			result = "redirect:/company/mypage/memberInfoPwd";
		}
		
		return result;
	}
	
	@PostMapping("/memberInfoUpdate")
	public String updateInfo(Member member, RedirectAttributes rttr, @AuthenticationPrincipal MemberImpl user) {
		
		String result;
		int result2 = 0;
		
		int result1 = memberInfoService.updateInfo(member);
		
		if(member.getPwd() != "") {
			result2 = memberInfoService.updatePwd(member);
		}
		
		Member mem =  memberInfoService.selectAll(member);
		
		user.setDetails(mem);
		
		if (result1 > 0) {
			System.out.println("회원 정보가 변경되었습니다.");
			rttr.addFlashAttribute("message", "회원 정보가 변경되었습니다.");
			result = "redirect:/company/mypage/memberInfoUpdate";
		} else {
			System.out.println("에러가 발생헀습니다.");
			rttr.addFlashAttribute("errorMessage", "에러가 발생헀습니다.");
			result = "redirect:/common/errorPage";
		}
		
		
		return result;
	}
	
	@PostMapping("/leaveCheckPwd")
	@ResponseBody
	public int deleteFile(@RequestParam("password") String password, @AuthenticationPrincipal MemberImpl user) {
		
	
		return passwordEncoder.matches(password, user.getPwd()) ? 1 : 0;
	}
	
	
}
