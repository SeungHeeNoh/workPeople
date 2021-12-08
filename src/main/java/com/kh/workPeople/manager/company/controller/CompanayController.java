package com.kh.workPeople.manager.company.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.ManagerCompanyInfo;
import com.kh.workPeople.manager.company.model.service.CompanyService;

@Controller
@RequestMapping("/manager/company")
public class CompanayController {

	@Autowired
	private CompanyService companyService;

	
	  @GetMapping("/companyinfo") 
	  public ModelAndView companyList(ModelAndView mv, @RequestParam(defaultValue = "1") int page) { 
		  Map<String, Object> map = companyService.clist(page);
		  
		  mv.addObject("companyList", map.get("companyList")); 
		  mv.addObject("pi", map.get("pi"));
		  mv.setViewName("manager/company/companyinfo");
		  return mv; 
	  }
	  
	@RequestMapping(value="/jvSelect", method=RequestMethod.GET)
	@ResponseBody
	public ManagerCompanyInfo vacancyNo( @RequestParam("no") int no){
	  ManagerCompanyInfo returnInfo = companyService.vacancyNo(no);
	  List<JobVacancy> jvList = companyService.getJobVacancyListByCompanyNum(returnInfo.getMember().getNo());
	  
	  returnInfo.setList(jvList);
	  returnInfo.setCount(jvList.size());
	  return returnInfo;
	}

	/* 모든 채팅방 조회 */
	@GetMapping("/customerservice")
	public String customerService(Model model) {



		return "manager/company/customerservice";
	}

	@GetMapping("/customerservice/{id}")
	public String chatRoomEnter(@PathVariable String id, Model model){


		return null;
	}






}
