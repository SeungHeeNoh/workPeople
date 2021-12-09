package com.kh.workPeople.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.MainTier;
import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.main.model.service.MainService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value= {"/", "/main"})
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		
		int cmCount = service.getCmCount();
		int jvCount = service.getJvCount();
		int skCount = service.getSkCount();
		mv.addObject("cmCount",cmCount);
		mv.addObject("jvCount",jvCount);
		mv.addObject("skCount",skCount);
		
		mv.setViewName("main/main");
		return mv;
	}
	
	@PostMapping(value= {"/", "/main"})
	public String redirectMain() {
		return "redirect:/";
	}

	@RequestMapping(value="/getPlatinumList")
	@ResponseBody
	public MainTier getPlatinumList(){
		MainTier returnTier = new MainTier();
		List<MainTier> tierList =  service.getPlatinumList();
		returnTier.setSize(tierList.size());
		
		if(tierList.size()>0) {
			returnTier.setList(tierList);
		}else {
			returnTier.setList(new ArrayList<>());
		}
		return returnTier;
	}
	
	
	@RequestMapping(value="/getBasicList")
	@ResponseBody
	public MainTier getBasicList(){
		MainTier returnTier = new MainTier();
		List<MainTier> tierList =  service.getBasicList();
		if(tierList.size()>0) {
			returnTier.setList(tierList);
			returnTier.setSize(tierList.size());
		}else {
			returnTier.setList(new ArrayList<>());
			returnTier.setSize(0);
		}
	
		return returnTier;
	}
	
	
	
	
}