package com.kh.workPeople.manager.company.model.service;

import java.util.Map;

import com.kh.workPeople.common.vo.CompanyInformation;

public interface CompanyService {


	Map<String, Object> clist(int page);

	CompanyInformation vacancyNo(int no); 




}
