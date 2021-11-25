package com.kh.workPeople.personal.mypage.interestedCompany.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.common.vo.UserImpl;
import com.kh.workPeople.personal.mypage.interestedCompany.model.service.InterestedCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personal/mypage")
public class InterestedCompanyController {

    public InterestedCompanyService interestedCompanyService;

    @Autowired
    public InterestedCompanyController(InterestedCompanyService interestedCompanyService) {
        this.interestedCompanyService = interestedCompanyService;
    }

    @GetMapping("interestedCompany")
    public String interestedCompany(Model model, @AuthenticationPrincipal UserImpl user){

        List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList = interestedCompanyService.jobVacancyLookUpSimpleList(user.getNo());

        model.addAttribute("jobList",jobVacancyLookUpSimpleList);

        return "personal/mypage/InterestedCompany";
    }

}
