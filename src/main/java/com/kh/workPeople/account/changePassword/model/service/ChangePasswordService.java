package com.kh.workPeople.account.changePassword.model.service;

import com.kh.workPeople.common.vo.MemberImpl;

public interface ChangePasswordService {

	int changePassword(MemberImpl memberImpl, String password);

}
