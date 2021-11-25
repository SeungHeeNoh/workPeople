package com.kh.workPeople.personal.mypage.latestPublication.model.dao;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LatestPublicationMapper {
    List<JobVacancyLookUp> jobVacancyLookUpList(int no);
}
