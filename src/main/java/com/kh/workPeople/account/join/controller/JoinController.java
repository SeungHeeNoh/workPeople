package com.kh.workPeople.account.join.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.account.join.model.service.JoinService;
import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.Sector;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/account/join")
public class JoinController {
	@Autowired
	private JoinService joinService;

	@GetMapping("/personal-join")
	public String personalJoin() {
		return "account/join/personal-join";
	}
	
	@PostMapping("/personal-signUp")
	public String personalSignUp(Member member, RedirectAttributes rttr) {
		int result = joinService.join(member);
		
		if(result > 0) {
			rttr.addFlashAttribute("successMessage", "회원가입이 완료되었습니다.");
		}

		return "redirect:/main";
	}
	
	@GetMapping("/company-join")
	public String companyJoin(Model model) {
		List<CompanyType> companyTypeList = joinService.selectCompanyTypeList();
		List<Sector> sectorList = joinService.selectSectorList();
		
		model.addAttribute("companyTypeList", companyTypeList);
		model.addAttribute("sectorList", sectorList);
		return "account/join/company-join";
	}

	@PostMapping("/company-signUp")
	public String companySignUp(Member member, CompanyInformation companyInformation, RedirectAttributes rttr) {
		int result = joinService.join(member, companyInformation);
		
		if(result > 0) {
			rttr.addFlashAttribute("successMessage", "회원가입이 완료되었습니다.");
		}
		
		return "redirect:/main";
	}
	
	@GetMapping(value="/member/{id}")
	@ResponseBody
	public Map<String, String> checkId(@PathVariable String id) {
		Map<String, String> map = new HashMap<>();
		String message = joinService.checkId(id) > 0 ? "이미 사용중인 아이디입니다." : "";

		map.put("message", message);
		
		return map;
	}
	
	@GetMapping(value="/company/{registerNumber}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, String> checkRegisterNumber(@PathVariable String registerNumber) throws Exception {
		Map<String, String> map = new HashMap<>();
		String message = joinService.checkRegisterNumber(registerNumber) > 0 ? "이미 가입한 기업회원입니다."  : "";

		map.put("message", message);

		return map;
	}
	
	@GetMapping(value="/mail/{email}")
	@ResponseBody
	public Map<String, String> sendMail(@PathVariable String email) {
		Map<String, String> map = new HashMap<>();
		String certString = joinService.sendCertifyMail(email);
		String message = "";

		if(certString.length() > 0) {
			message = "인증 번호가 발송되었습니다.";
		} else {
			message = "메일을 보내는 데에 실패했습니다.";	
		}
		
		map.put("certString", certString);
		map.put("message", message);

		return map;
	}

}
