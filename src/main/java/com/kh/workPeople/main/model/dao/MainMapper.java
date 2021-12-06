package com.kh.workPeople.main.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.workPeople.common.vo.MainTier;
import com.kh.workPeople.jobs.job.model.dao.JobMapper;

@Mapper
public interface MainMapper {

	int getJvCount();

	int getSkCount();

	int getCmCount();
	
	List<MainTier> getPlatinumList();
	List<MainTier> getBasicList();
	

	
}
