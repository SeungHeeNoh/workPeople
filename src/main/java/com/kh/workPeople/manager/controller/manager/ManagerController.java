package com.kh.workPeople.manager.controller.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.manager.model.service.ManagerService;
import com.kh.workPeople.manager.model.vo.Manager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/manager/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/managerinfo")
	public ModelAndView managerList(ModelAndView mv, @RequestParam(defaultValue="1") int page) {
		System.out.println(page);
		
		Map<String, Object> map = managerService.mlist(page);
		
		mv.addObject("managerList", map.get("managerList"));
		mv.addObject("pi", map.get("pi"));
		mv.setViewName("manager/manager/managerinfo");
		
	return mv;
	}
	

	
		
		
	
	}
