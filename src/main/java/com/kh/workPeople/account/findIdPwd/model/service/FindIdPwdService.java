package com.kh.workPeople.account.findIdPwd.model.service;

import java.util.Map;

import com.kh.workPeople.common.vo.Member;

public interface FindIdPwdService {

	Member findMemberForId(Map<String, String> input);
	
	Member findMemberForPwd(Map<String, String> input);
	
	int sendMail(Member member);

	int sendTempPwdMail(Member member);

}
