package com.kh.workPeople.manager.manager.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.account.join.model.dao.JoinMapper;
import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.common.vo.ManagerRole;
import com.kh.workPeople.common.vo.MemberRole;
import com.kh.workPeople.manager.manager.model.service.ManagerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/manager/manager")
public class ManagerController {
	
	
	@Autowired
	private ManagerService managerService;
	

	@GetMapping("/managerinfo")
	public ModelAndView managerList(ModelAndView mv, @RequestParam(defaultValue="1") int page) {
		Map<String, Object> map = managerService.mlist(page);
		
		mv.addObject("managerList", map.get("managerList"));
		mv.addObject("pi", map.get("pi"));
		mv.setViewName("manager/manager/managerinfo");
		
		return mv;
	}
	
	@RequestMapping(value="/classChange", method=RequestMethod.GET)
	@ResponseBody
	public Manager classChange(@RequestParam("imNo") int imNo){
		
		Manager manager = managerService.classManager(imNo);
		
		return manager;
		
	}
	
	@RequestMapping("/classChangeManager")
	public String classChangeManager3(RedirectAttributes rttr,
			@RequestParam("imNo") int imNo, 
			@RequestParam("mClass") int mClass, @RequestParam("code") int code,
			 @RequestParam(defaultValue="1") int page) {
		
		if(mClass != code) { 
			int result = 0;
			if(mClass == 4) {
				result = managerService.classDeleteManager(imNo, code);
			} else if(mClass == 3){
				result = managerService.classInsertManager(imNo, code);
			}
			
			if (result > 0) {
				rttr.addFlashAttribute("successMessage", "직급이 변경되었습니다.");
			}
		}
		return "redirect:/manager/manager/managerinfo";
	}
	

	
	@RequestMapping(value="/createManager", method=RequestMethod.POST)
	public String createManager(RedirectAttributes rttr, 
			@RequestParam("imPwd2")  String imPwd2,
			@RequestParam("imId2") String imId2,
			@RequestParam("imName2")  String imName2
			) {
		Manager manager  = new Manager();
		manager.setImId(imId2);
		manager.setImName(imName2);
		manager.setImPwd(imPwd2);	
		manager.setImPwd(managerService.encodePwd(manager.getImPwd()));
		
		
		ManagerRole managerRole = new ManagerRole();
		managerRole.setaCode(4);
		
		int result1 = managerService.createManager(manager);
		Manager inputManager = managerService.getManagerByImId(imId2);
		managerRole.setImNo(inputManager.getImNo());
		int result2 = managerService.insertManagerRole(managerRole);
		
			if (result1 > 0 && result2 >0) {
				rttr.addFlashAttribute("successMessage", "회원가입이 완료되었습니다.");
			}
		
		
		return "redirect:/manager/manager/managerinfo";
	}
	
	
	@RequestMapping(value="/idOverLapCheck", method=RequestMethod.GET)
	@ResponseBody
	public String idOverLapCheck(HttpServletRequest request,
			@RequestParam("imId2") String imId2) {
		
		
		String msg ="";
		int overLapManager = managerService.idOverLapCheck(imId2);
		if(overLapManager>0) {
			msg = "overLap";
		}else {
			msg = "중복되지 않았습니다";
		}
		
		return msg;
	}
	
	
	
	
	
}

	
		
		
	
