package com.kh.workPeople.company.mypage.talented.service;

import java.util.Map;

public interface TalentedService {

	Map<String, Object> findList(int page, int userNo);

	int insertResume(int rno, int cino);

	int selectResumeCount(int rno, int cino);


	

}
