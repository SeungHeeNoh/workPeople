package com.kh.workPeople.manager.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/manager")
public class ManagerController {
	
		@GetMapping("/managerinfo")
		public String managerInfo() {
			return "manager/manager/managerinfo";
		}
		
	
	}
