package com.kh.workPeople.personal.mypage.latestPublication.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.personal.mypage.latestPublication.model.service.LatestPublicationService;
import org.apache.ibatis.javassist.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/personal/mypage")
public class LatestPublicationController {

    private final LatestPublicationService latestPublicationService;

    @Autowired
    public LatestPublicationController(LatestPublicationService latestPublicationService) {
        this.latestPublicationService = latestPublicationService;
    }

    @GetMapping("latestPublication")
    public String latestPublication(Model model, @AuthenticationPrincipal MemberImpl user){

        List<JobVacancyLookUp> jobVacancyLookUpList = latestPublicationService.jobVacancyLookUpList(user.getNo());

        model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);

        return "personal/mypage/latestPublication";
    }
}
