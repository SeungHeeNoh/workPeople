package com.kh.workPeople.personal.mypage.interview.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUpSimple;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.personal.mypage.interview.model.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/personal/mypage")
public class InterviewController {

    private final InterviewService interviewService;

    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("interview")
    public String interview(Model model, @AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue = "1") int page){

        Map<String,Object> interviewMap = interviewService.jobVacancyLookUpSimpleListPaging(user.getNo(),page);

        List<JobVacancyLookUpSimple> jobVacancyLookUpSimpleList = (List<JobVacancyLookUpSimple>)interviewMap.get("jobVacancyLookUpSimpleList");

        for(JobVacancyLookUpSimple job : jobVacancyLookUpSimpleList){

            if(job.getAiStatusYN().equals("Y")){
                job.setAiStatusYNFormat(0);
            } else{
                job.setAiStatusYNFormat(1);
            }
        }

        model.addAttribute("jobVacancyLookUpSimpleList",jobVacancyLookUpSimpleList);
        model.addAttribute("pi",interviewMap.get("pi"));

        return "personal/mypage/interview";
    }

    @PostMapping("interview/delete")
    public String deleteInterview(@RequestParam("aiNo") List<Integer> aiNoList, RedirectAttributes rttr, HttpServletRequest request ){

        System.out.println("aiNoList1 : "+aiNoList);
        int result = interviewService.deleteInterview(aiNoList);

        if(result>0){
            rttr.addFlashAttribute("message","선택하신 면접 현황 삭제에 성공했습니다.");
            return "redirect:/personal/mypage/interview";
        }else{
            request.setAttribute("message","선택하신 이력서 열람기업 삭제에 실패했습니다.");
            return "/common/errorPage";
        }

    }

}
