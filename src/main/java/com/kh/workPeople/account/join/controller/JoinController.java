package com.kh.workPeople.account.join.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.workPeople.account.join.model.service.JoinService;
import com.kh.workPeople.common.vo.CompanyType;
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
	
	@GetMapping("/company-join")
	public String companyJoin(Model model) {
		List<CompanyType> companyTypeList = joinService.selectCompanyTypeList();
		List<Sector> sectorList = joinService.selectSectorList();
		
		model.addAttribute("companyTypeList", companyTypeList);
		model.addAttribute("sectorList", sectorList);
		return "account/join/company-join";
	}
	
	@GetMapping(value="/checkRegisterNumber/{registerNumber}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, String> checkRegisterNumber(@PathVariable int registerNumber) throws Exception {
		Map<String, String> map = new HashMap<>();
		String msg = joinService.checkRegisterNumber(registerNumber) > 0 ? "이미 가입한 기업회원입니다."  : "";

		map.put("msg", msg);

		return map;
	}
}
