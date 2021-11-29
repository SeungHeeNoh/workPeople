package com.kh.workPeople.manager.company.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.manager.company.model.dao.CompanyMapper;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyMapper companyMapper;
	
	@Autowired
	public CompanyServiceImpl(CompanyMapper companyMapper) {
		this.companyMapper = companyMapper;
	}

	
	  @Override public Map<String, Object> clist(int page) { 
		  Map<String, Object> returnMap = new HashMap<>(); int listCount = companyMapper.getListCount();
	  
		  PageInfo pi = new PageInfo(page, listCount, 5, 10);
		  
		  List<CompanyInformation> companyList = companyMapper.selectList(pi);
		  
		  returnMap.put("pi", pi); returnMap.put("companyList", companyList);
		  
		  return returnMap; 
	  }
	 

	
}