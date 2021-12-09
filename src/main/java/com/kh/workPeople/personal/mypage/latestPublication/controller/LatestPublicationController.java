package com.kh.workPeople.personal.mypage.latestPublication.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.kh.workPeople.personal.mypage.latestPublication.model.service.LatestPublicationService;
import lombok.extern.log4j.Log4j;
import org.apache.commons.logging.Log;
import org.apache.ibatis.javassist.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String latestPublication(Model model, @AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue = "1") int page){

        Map<String,Object> lpMap = latestPublicationService.jobVacancyLookUpListPaging(user.getNo(),page);

        List<JobVacancyLookUp> jobVacancyLookUpList = (List<JobVacancyLookUp>)lpMap.get("jobVacancyLookUpList");

        for(JobVacancyLookUp job : jobVacancyLookUpList){
            int applyCompanyYN = homeService.applyCompanyYN(user.getNo(),job.getJvNo());

            if(applyCompanyYN > 0){
                job.setApplyYN(true);
            } else{
                job.setApplyYN(false);
            }
        }

        model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);
        model.addAttribute("pi",lpMap.get("pi"));

        Resume resume = homeService.selectResumeStatusY(user.getNo());
        if(resume != null){
            model.addAttribute("resume",resume);
            model.addAttribute("resumeNo",resume.getNo());
        }
        return "personal/mypage/latestPublication";
    }

    @GetMapping("latestPublication/applyResume/{rNo},{applyBtnNo}")
    public String applyResume(@AuthenticationPrincipal MemberImpl user,@PathVariable int applyBtnNo, RedirectAttributes rttr){

        int applyCompany = applyCompanyService.applyCompany(user.getNo(),applyBtnNo);
        int appliedInsertCompany = applyCompanyService.insertAppliedTable(user.getNo(),applyBtnNo);


        if(applyCompany>0){
            rttr.addFlashAttribute("message","입사지원이 완료되었습니다.");
            return "redirect:/personal/mypage/latestPublication";
        } else{
            rttr.addFlashAttribute("errorMessage","입사지원에 실패하셨습니다.");
            return "redirect:/common/errorPage";
        }

    }

    @GetMapping("latestPublication/delete/{jvNo}")
    public String latestPublicationDelete(@PathVariable("jvNo") List<Integer> jvNoList, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request){


//        System.out.println("jvnolist : "+jvNoList);
        Map<String, Object> queryMap = new HashMap<>();
        int result = 0;

        queryMap.put("userNo", user.getNo());
        queryMap.put("jvNoList", jvNoList);

        result = latestPublicationService.deleteLatestPublication(queryMap);

        if(result > 0) {
            rttr.addFlashAttribute("message", "선택하신 최근 본 채용공고 목록 삭제에 성공했습니다.");
            return "redirect:/personal/mypage/latestPublication";
        } else {
            request.setAttribute("errorMessage", "선택하신 스크랩 공고 목록 삭제에 실패했습니다.");
            return "/common/errorPage";
        }

    }































}
