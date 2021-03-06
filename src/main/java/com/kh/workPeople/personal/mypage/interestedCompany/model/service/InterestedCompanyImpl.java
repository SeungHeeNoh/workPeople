package com.kh.workPeople.personal.mypage.interestedCompany.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.personal.mypage.interestedCompany.model.dao.InterestedCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
	public int deleteInterestedCompanyList(Map<String, Object> queryMap) {
		return interestedCompanyMapper.deleteInterestedCompanyList(queryMap);
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

	@Override
	public int getInterestedCompanyCount(int companyNo) {
		return interestedCompanyMapper.getInterestedCompanyCount(companyNo);
	}

	@Override
	public Map<String, Object> jobVacancyLookUpSimpleListPaging(int no, int page) {

		Map<String, Object> returnMap = new HashMap<>();

		int listCount = interestedCompanyMapper.jobVacancyLookUpSimpleList(no).size();

		PageInfo pi = new PageInfo(page,listCount,10,10,no);

		List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList = interestedCompanyMapper.jobVacancyLookUpSimpleListPagingQuery(pi);

		returnMap.put("pi",pi);
		returnMap.put("jobVacancyLookUpSimpleList",jobVacancyLookUpSimpleList);

		return returnMap;
	}
}
