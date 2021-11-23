package com.kh.workPeople.manager.controller.company;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/company")
public class CompanayController {
	
		@GetMapping("/companyinfo")
		public String companyInfo(Model model) {

			return "manager/company/companyinfo";
		}
		
		@GetMapping("/customerservice")
		public String customerService(Model model) {
			return "manager/company/customerservice";
		}
	}
