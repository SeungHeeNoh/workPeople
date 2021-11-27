package com.kh.workPeople.account.findIdPwd.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.workPeople.account.findIdPwd.model.service.FindIdPwdService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/account/find-id-pwd")
public class FindIdPwdController {
	
	@Autowired
	private FindIdPwdService findIdPwdService;

	@RequestMapping(value={"/", "/main"})
	public String findIdPwdMain() {
		return "account/find-id-pwd/main";
	}

	@GetMapping("/personal/find-id")
	public String personalFindId(Model model) {
		model.addAttribute("memberType", "personal");

		return "account/find-id-pwd/find-id";
	}
	
	@GetMapping("/personal/find-pwd")
	public String personalFindPwd(Model model) {
		model.addAttribute("memberType", "personal");

		return "account/find-id-pwd/find-pwd";
	}
	
	@GetMapping("/company/find-id")
	public String companyFindId(Model model) {
		model.addAttribute("memberType", "company");

		return "account/find-id-pwd/find-id";
	}
	
	@GetMapping("/company/find-pwd")
	public String companyFindPwd(Model model) {
		model.addAttribute("memberType", "company");

		return "account/find-id-pwd/find-pwd";
	}
	
	@PostMapping(value="/personal/member/id", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, String> findId(@RequestBody Map<String, String> input) {
		Map<String, String> map = new HashMap<>();
		String message = "";
		String id = findIdPwdService.findPersonalId(input);	
		
		if(id != null) {
			int result = findIdPwdService.sendMail(input.get("email"), id);

			if(result > 0) {
				message = "아이디가 메일로 발송되었습니다.";
			} else {
				message = "메일을 보내는 데에 실패했습니다.";
			}
		} else {
			message = "입력된 정보를 가진 계정이 존재하지 않습니다.";
		}

		map.put("message", message);
		return map;
	}
}
