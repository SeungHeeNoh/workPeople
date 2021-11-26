package com.kh.workPeople.personal.mypage.home.model.dao;

import com.kh.workPeople.common.vo.Resume;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {

    Resume selectResumeStatusY(int no);

}
