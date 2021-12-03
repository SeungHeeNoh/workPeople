package com.kh.workPeople.company.mypage.memberInfo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.workPeople.common.vo.Member;


@Mapper
public interface MemberInfoMapper {

	int updateInfo(Member member);

	int updatePwd(Member member);

	Member selectAll(Member member);

	int leave(int no);


	// 개인회원 정보 수정
	int updatePersonalInfo(Member member);

}
