package com.kh.workPeople.personal.mypage.interview.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.common.vo.UserImpl;
import com.kh.workPeople.personal.mypage.interview.model.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personal/mypage")
public class InterviewController {

    private InterviewService interviewService;

    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("interview")
    public String interview(Model model, @AuthenticationPrincipal UserImpl user){

        List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList = interviewService.jobVacancyLookUpSimpleList(user.getNo());

        model.addAttribute("jobVacancyLookUpSimpleList",jobVacancyLookUpSimpleList);

        return "personal/mypage/interview";
    }
}
