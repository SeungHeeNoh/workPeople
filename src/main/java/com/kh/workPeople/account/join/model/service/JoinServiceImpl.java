package com.kh.workPeople.account.join.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.join.model.dao.JoinMapper;
import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Sector;

@Service()
public class JoinServiceImpl implements JoinService {
	
	@Autowired
	private JoinMapper joinMapper;

	@Override
	public int checkRegisterNumber(int registerNumber) {
		return joinMapper.checkRegisterNumber(registerNumber);
	}

	@Override
	public List<CompanyType> selectCompanyTypeList() {
		return joinMapper.selectCompanyTypeList();
	}

	@Override
	public List<Sector> selectSectorList() {
		return joinMapper.selectSectorList();
	}

	@Override
	public int checkId(String id) {
		return joinMapper.checkId(id);
	}

}
