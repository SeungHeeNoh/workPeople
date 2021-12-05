package com.kh.workPeople.company.mypage.talented.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.PersonInfoResume;

@Mapper
public interface TalentedMapper {

	CompanyInformation userSnoNumber(int userNo);

	int getListCount(int userSno);

	List<PersonInfoResume> selectList(Map<String, Object> noMap);
	
	int selectResumeCount(@Param("rno") int rno, @Param("cino") int cino);

	int insertResume(@Param("rno") int rno, @Param("cino") int cino);

	int insertscrap(@Param("mno") int mno, @Param("rno") int rno);

	int deletescrap(@Param("mno") int mno, @Param("rno") int rno);

	List<PersonInfoResume> selectScrapList(Map<String, Object> noMap);

	int scrapListCount(int userNo);

	

	

	

}
