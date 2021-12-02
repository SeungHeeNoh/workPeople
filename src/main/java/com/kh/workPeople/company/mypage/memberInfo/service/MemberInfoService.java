package com.kh.workPeople.company.mypage.memberInfo.service;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;

public interface MemberInfoService {

	int updateInfo(Member member);

	int updatePwd(Member member);

	Member selectAll(Member member);

	int leave(MemberImpl user);


}
