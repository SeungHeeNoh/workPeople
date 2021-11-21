package com.kh.workPeople.account.join.model.service;

import java.util.List;

import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Sector;

public interface JoinService {

	public int checkRegisterNumber(int registerNumber);

	public List<CompanyType> selectCompanyTypeList();

	public List<Sector> selectSectorList();
}
