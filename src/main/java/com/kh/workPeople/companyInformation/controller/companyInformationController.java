package com.kh.workPeople.companyInformation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company-information")
public class companyInformationController {

	@GetMapping("/detail-view")
	public String detailView() {
		return "companyInformation/detailView";
	}
}
