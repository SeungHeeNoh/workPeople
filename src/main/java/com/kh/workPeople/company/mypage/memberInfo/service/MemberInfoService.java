package com.kh.workPeople.company.mypage.memberInfo.service;

import com.kh.workPeople.common.vo.Member;

public interface MemberInfoService {

	int updateInfo(Member member);

	int updatePwd(Member member);

	Member selectAll(Member member);


}
