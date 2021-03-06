package com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.service;

import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.common.vo.ResumeBrowseCompany;
import com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.dao.ResumeBrowseCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResumeBrowseCompanyServiceImpl implements ResumeBrowseCompanyService{

    private final ResumeBrowseCompanyMapper resumeBrowseCompanyMapper;

    @Autowired
    public ResumeBrowseCompanyServiceImpl(ResumeBrowseCompanyMapper resumeBrowseCompanyMapper){
        this.resumeBrowseCompanyMapper = resumeBrowseCompanyMapper;
    }


    @Override
    public List<ResumeBrowseCompany> selectResumeBrowseCompanyList(int no) {
        return resumeBrowseCompanyMapper.selectResumeBrowseCompanyList(no);
    }


    @Override
    public Map<String, Object> selectResumeBrowseCompanyListPaging(int no, int page) {

        Map<String, Object> returnMap = new HashMap<>();

        int listCount = resumeBrowseCompanyMapper.selectResumeBrowseCompanyList(no).size();

        PageInfo pi = new PageInfo(page,listCount,10,10,no);

        List<ResumeBrowseCompany> selectResumeBrowseCompanyList = resumeBrowseCompanyMapper.selectResumeBrowseCompanyListPagingQuery(pi);

        returnMap.put("pi",pi);
        returnMap.put("selectResumeBrowseCompanyList",selectResumeBrowseCompanyList);

        return returnMap;
    }

    @Override
    public int deleteResumeBrowseCompanyList(int no, List<Integer> ciNoList) {

        int result=0;

        for(Integer ciNo : ciNoList){

            Map<String, Integer> deleteMap = new HashMap<>();
            deleteMap.put("userNo",no);
            deleteMap.put("ciNo",ciNo);

            int result2 = resumeBrowseCompanyMapper.deleteResumeBrowseCompanyListMap(deleteMap);
            result += result2;
        }
        return result;
    }









}
