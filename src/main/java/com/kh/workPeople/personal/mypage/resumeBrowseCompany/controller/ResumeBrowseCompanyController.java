package com.kh.workPeople.personal.mypage.resumeBrowseCompany.controller;

import com.kh.workPeople.common.vo.ResumeBrowseCompany;
import com.kh.workPeople.common.vo.UserImpl;
import com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.service.ResumeBrowseCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("personal/mypage")
public class ResumeBrowseCompanyController {

    private ResumeBrowseCompanyService resumeBrowseCompanyService;

    @Autowired
    public ResumeBrowseCompanyController(ResumeBrowseCompanyService resumeBrowseCompanyService) {
        this.resumeBrowseCompanyService = resumeBrowseCompanyService;
    }

    @GetMapping("resumeBrowseCompany")
    public String resumeBrowseCompany(Model model, @AuthenticationPrincipal UserImpl user){

        List<ResumeBrowseCompany> resumeBrowseCompanyList = resumeBrowseCompanyService.selectResumeBrowseCompanyList(user.getNo());

        for(ResumeBrowseCompany rbc : resumeBrowseCompanyList){
            Date beforeDate = rbc.getRb_date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
            String afterDate = simpleDateFormat.format(beforeDate);
            rbc.setRb_date_format(afterDate);
        }

//        System.out.println(resumeBrowseCompanyList);

        model.addAttribute("companyList",resumeBrowseCompanyList);

        return "personal/myPage/resumeBrowseCompany";
    }
}
