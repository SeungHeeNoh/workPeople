package com.kh.workPeople.manager.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/user")
public class userController {
	
		@GetMapping("/userinfo")
		public String userInfo(Model model) {
			return "manager/user/userinfo";
		}
		
		@GetMapping("/customerservice")
		public String userCustomerService(Model model) {

			return "manager/user/customerservice";
		}
		
	
	}
