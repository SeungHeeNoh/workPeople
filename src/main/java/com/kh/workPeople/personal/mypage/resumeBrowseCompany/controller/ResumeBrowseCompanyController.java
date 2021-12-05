package com.kh.workPeople.personal.mypage.resumeBrowseCompany.controller;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.ResumeBrowseCompany;
import com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.service.ResumeBrowseCompanyService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("personal/mypage")
public class ResumeBrowseCompanyController {

    private final ResumeBrowseCompanyService resumeBrowseCompanyService;

    @Autowired
    public ResumeBrowseCompanyController(ResumeBrowseCompanyService resumeBrowseCompanyService) {
        this.resumeBrowseCompanyService = resumeBrowseCompanyService;
    }

    @GetMapping("resumeBrowseCompany")
    public String resumeBrowseCompany(Model model, @AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue = "1") int page){

        Map<String, Object> companyMap = resumeBrowseCompanyService.selectResumeBrowseCompanyListPaging(user.getNo(),page);

        List<ResumeBrowseCompany> resumeBrowseCompanyList = (List<ResumeBrowseCompany>)companyMap.get("selectResumeBrowseCompanyList");

        for(ResumeBrowseCompany rbc : resumeBrowseCompanyList){
            Date beforeDate = rbc.getRb_date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
            String afterDate = simpleDateFormat.format(beforeDate);
            rbc.setRb_date_format(afterDate);
        }

        model.addAttribute("companyList",resumeBrowseCompanyList);
        model.addAttribute("pi",companyMap.get("pi"));

        return "personal/myPage/resumeBrowseCompany";
    }

    @PostMapping("resumeBrowseCompany/delete")
    public String deleteResumeBrowseCompanyList(@RequestParam("ciNo") List<Integer> ciNoList, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request){

        int result = resumeBrowseCompanyService.deleteResumeBrowseCompanyList(user.getNo(),ciNoList);

        if(result>0){
            rttr.addFlashAttribute("message","선택하신 이력서 열람기업 삭제에 성공했습니다.");
            return "redirect:/personal/mypage/resumeBrowseCompany";
        }else{
            request.setAttribute("message","선택하신 이력서 열람기업 삭제에 실패했습니다.");
            return "/common/errorPage";
        }

    }





























}
