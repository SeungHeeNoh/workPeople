package com.kh.workPeople.personal.mypage.latestPublication.model.service;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.personal.mypage.latestPublication.model.dao.LatestPublicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LatestPublicationServiceImpl implements LatestPublicationService {

    private LatestPublicationMapper latestPublicationMapper;

    @Autowired
    public LatestPublicationServiceImpl(LatestPublicationMapper latestPublicationMapper) {
        this.latestPublicationMapper = latestPublicationMapper;
    }

    @Override
    public List<JobVacancyLookUp> jobVacancyLookUpList(int no) {
        return latestPublicationMapper.jobVacancyLookUpList(no);
    }
}
