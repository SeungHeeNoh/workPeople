package com.kh.workPeople.personal.mypage.scrap.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.personal.mypage.scrap.model.dao.ScrapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScrapServiceImpl implements ScrapService{

    private final ScrapMapper scrapMapper;

    @Autowired
    public ScrapServiceImpl(ScrapMapper scrapMapper){
        this.scrapMapper = scrapMapper;
    }

    @Override
    public List<JobVacancyLookUp> jobVacancyLookUpList(int no) {
        return scrapMapper.jobVacancyLookUpList(no);
    }

	@Override
	public int insertScrap(Map<String, Integer> queryMap) {
		return scrapMapper.insertScrap(queryMap);
	}

	@Override
	public int deleteScrap(Map<String, Integer> queryMap) {
		return scrapMapper.deleteScrap(queryMap);
	}
    
}
