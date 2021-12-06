package com.kh.workPeople.manager.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.manager.user.model.service.UserService;



@Controller
@RequestMapping("/manager/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
		@GetMapping("/userinfo")
		public ModelAndView userList(ModelAndView mv, @RequestParam(defaultValue="1") int page) {
			Map<String, Object> map = userService.ulist(page);
			
			mv.addObject("userList", map.get("userList"));
			mv.addObject("pi", map.get("pi"));
			mv.setViewName("manager/user/userinfo");
			
			
			return mv;
		}
		
		@GetMapping("/customerservice")
		public String userCustomerService(Model model) {

			return "manager/user/customerservice";
		}
		
		
	
	}
