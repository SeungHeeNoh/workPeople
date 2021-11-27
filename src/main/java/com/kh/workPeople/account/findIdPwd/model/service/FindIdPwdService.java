package com.kh.workPeople.account.findIdPwd.model.service;

import java.util.Map;

public interface FindIdPwdService {

	String findPersonalId(Map<String, String> input);

	int sendMail(String email, String id);

	String findCompanyId(Map<String, String> input);

}
