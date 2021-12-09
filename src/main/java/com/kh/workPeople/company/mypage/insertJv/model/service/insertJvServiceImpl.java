package com.kh.workPeople.company.mypage.insertJv.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.company.mypage.insertJv.model.dao.insertJvMapper;

@Service
public class insertJvServiceImpl implements insertJvService{
	
	private insertJvMapper insertJvMapper;

	@Autowired
	public insertJvServiceImpl(insertJvMapper insertJvMapper) {
		this.insertJvMapper = insertJvMapper;
	}
	


	@Override
	public List<JobVacancy> jobVacancyInfoSelect(int cino) {
		return insertJvMapper.jobVacancyInfoSelect(cino);
	}


	@Override
	public int insertInfo(JobVacancy jobVacancy, int cino) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("job", jobVacancy);
		map.put("cino", cino);
		
		int result = insertJvMapper.insertInfo(map);
		
		return result;
	}

}
