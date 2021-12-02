package com.kh.workPeople.personal.mypage.latestPublication.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.kh.workPeople.personal.mypage.latestPublication.model.service.LatestPublicationService;
import org.apache.ibatis.javassist.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/personal/mypage")
public class LatestPublicationController {

    private final LatestPublicationService latestPublicationService;
    private final HomeService homeService;
    private final ApplyCompanyService applyCompanyService;

    @Autowired
    public LatestPublicationController(LatestPublicationService latestPublicationService,HomeService homeService,ApplyCompanyService applyCompanyService) {
        this.latestPublicationService = latestPublicationService;
        this.homeService=homeService;
        this.applyCompanyService = applyCompanyService;
    }

    @GetMapping("latestPublication")
    public String latestPublication(Model model, @AuthenticationPrincipal MemberImpl user){

        List<JobVacancyLookUp> jobVacancyLookUpList = latestPublicationService.jobVacancyLookUpList(user.getNo());




        model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);

        Resume resume = homeService.selectResumeStatusY(user.getNo());
        if(resume != null){
            model.addAttribute("resume",resume);
            model.addAttribute("resumeNo",resume.getNo());
        }
        return "personal/mypage/latestPublication";
    }

    @GetMapping("latestPublication/applyResume/{rNo},{applyBtnNo}")
    public String applyResume(@PathVariable int rNo, @PathVariable int applyBtnNo, RedirectAttributes rttr){

        int applyCompany = applyCompanyService.applyCompany(rNo,applyBtnNo);

        if(applyCompany>0){
            return "redirect:/personal/mypage/latestPublication";
        } else{
            rttr.addFlashAttribute("errorMessage","입사지원에 실패하셨습니다.");
            return "redirect:/common/errorPage";
        }


    }




}
