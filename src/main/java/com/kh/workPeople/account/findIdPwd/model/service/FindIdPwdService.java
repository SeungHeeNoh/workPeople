package com.kh.workPeople.account.findIdPwd.model.service;

import java.util.Map;

import com.kh.workPeople.common.vo.Member;

public interface FindIdPwdService {

	Member findMember(Map<String, String> input);
	
	int sendMail(String email, String id);


}
