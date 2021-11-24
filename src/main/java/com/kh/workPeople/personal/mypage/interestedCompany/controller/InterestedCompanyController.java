package com.kh.workPeople.personal.mypage.interestedCompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal/mypage")
public class InterestedCompanyController {

    @GetMapping("interestedCompany")
    public String interestedCompany(){





        return "personal/mypage/InterestedCompany";
    }

}
