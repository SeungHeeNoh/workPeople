package com.kh.workPeople.personal.mypage.scrap.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.personal.mypage.scrap.model.dao.ScrapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public Map<String, Object> jobVacancyLookUpListPaging(int no, int page) {

        Map<String, Object> returnMap = new HashMap<>();

        int listCount = scrapMapper.jobVacancyLookUpList(no).size();

        PageInfo pi = new PageInfo(page,listCount,10,10,no);


        List<JobVacancyLookUp> jobVacancyLookUpList = scrapMapper.jobVacancyLookUpListPagingQuery(pi);

        returnMap.put("pi",pi);
        returnMap.put("jobVacancyLookUpList",jobVacancyLookUpList);

        return returnMap;
    }

    @Override
    public List<JobVacancyLookUp> jobVacancyLookUpListPagingQuery(PageInfo pi) {
        return scrapMapper.jobVacancyLookUpListPagingQuery(pi);
    }
}
