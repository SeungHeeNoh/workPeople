package com.kh.workPeople.manager.company.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.manager.company.model.service.CompanyService;

@Controller
@RequestMapping("/manager/company")
public class CompanayController {

	@Autowired
	private CompanyService companyService;

	
	  @GetMapping("/companyinfo") public ModelAndView companyList(ModelAndView
	  mv, @RequestParam(defaultValue = "1") int page) { 
		  Map<String, Object> map = companyService.clist(page);
	  
	  mv.addObject("companyList", map.get("companyList")); 
	  mv.addObject("pi", map.get("pi"));
	  mv.setViewName("manager/company/companyinfo");
	  
	  return mv; 
	  
	  }
	  
	  @RequestMapping(value="/jvSelect", method=RequestMethod.GET)
		@ResponseBody
		public CompanyInformation vacancyNo( @RequestParam("no") int no){
		  CompanyInformation companyInformation = companyService.vacancyNo(no);
		  
			return companyInformation;
			
		}
	 

	@GetMapping("/customerservice")
	public String customerService(Model model) {
		return "manager/company/customerservice";
	}
}
