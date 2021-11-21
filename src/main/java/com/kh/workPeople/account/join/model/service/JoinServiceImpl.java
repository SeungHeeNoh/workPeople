package com.kh.workPeople.account.join.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.join.model.dao.JoinMapper;

@Service()
public class JoinServiceImpl implements JoinService {
	
	@Autowired
	private JoinMapper joinMapper;

	@Override
	public int checkRegisterNumber(int registerNumber) {
		return joinMapper.checkRegisterNumber(registerNumber);
	}

}
