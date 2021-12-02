package com.kh.workPeople.personal.mypage.interestedCompany.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.personal.mypage.interestedCompany.model.dao.InterestedCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InterestedCompanyImpl implements InterestedCompanyService{

    private final InterestedCompanyMapper interestedCompanyMapper;

    @Autowired
    public InterestedCompanyImpl(InterestedCompanyMapper interestedCompanyMapper){
        this.interestedCompanyMapper = interestedCompanyMapper;
    }

    @Override
    public List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList(int no) {
        return interestedCompanyMapper.jobVacancyLookUpSimpleList(no);
    }

    @Override
    public int jobVacancyCount(int no) {
        return interestedCompanyMapper.jobVacancyCount(no);
    }

	@Override
	public int insertInterestedCompany(Map<String, Integer> queryMap) {
		return interestedCompanyMapper.insertInterestedCompany(queryMap);
	}

	@Override
	public int deleteInterestedCompany(Map<String, Integer> queryMap) {
		return  interestedCompanyMapper.deleteInterestedCompany(queryMap);
	}
}
