package com.kh.workPeople.company.mypage.talented.service;

import java.util.Map;

public interface TalentedService {

	Map<String, Object> findList(int page, int userNo);

	int insertResume(int rno, int cino);

	int selectResumeCount(int rno, int cino);

	int insertscrap(int mno, int rno);

	int deletescrap(int mno, int rno);

	Map<String, Object> findScrapList(int page, int userNo);

	


	

}
