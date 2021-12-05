package com.kh.workPeople.personal.mypage.latestPublication.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.personal.mypage.latestPublication.model.dao.LatestPublicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LatestPublicationServiceImpl implements LatestPublicationService {

    private final LatestPublicationMapper latestPublicationMapper;

    @Autowired
    public LatestPublicationServiceImpl(LatestPublicationMapper latestPublicationMapper) {
        this.latestPublicationMapper = latestPublicationMapper;
    }

    @Override
    public List<JobVacancyLookUp> jobVacancyLookUpList(int no) {
        return latestPublicationMapper.jobVacancyLookUpList(no);
    }
    
    @Override
	public int updateBrowse(Map<String, Object> queryMap) {
    	int result1 = 1;
    	int result2 = 0;
    	boolean exist = latestPublicationMapper.getBrowseCount(queryMap) > 0 ? true : false;

    	if(exist) {
    		result1 = latestPublicationMapper.deleteBrowse(queryMap);
    	}
    	
    	if(result1 > 0) {
    		result2 = latestPublicationMapper.insertBrowse(queryMap);
    	}

		return (result1 > 0 && result2 > 0) ? 1 : 0;
	}

	@Override
	public Map<String, Object> jobVacancyLookUpListPaging(int no, int page) {

		Map<String, Object> returnMap = new HashMap<>();

		int listCount = latestPublicationMapper.jobVacancyLookUpList(no).size();

		PageInfo pi = new PageInfo(page,listCount,10,10,no);

		List<JobVacancyLookUp> jobVacancyLookUpList = latestPublicationMapper.jobVacancyLookUpListPagingQuery(pi);

		returnMap.put("pi",pi);
		returnMap.put("jobVacancyLookUpList",jobVacancyLookUpList);

		return returnMap;
	}

	@Override
	public int deleteLatestPublication(Map<String, Object> queryMap) {
		return latestPublicationMapper.deleteLatestPublication(queryMap);
	}

}
