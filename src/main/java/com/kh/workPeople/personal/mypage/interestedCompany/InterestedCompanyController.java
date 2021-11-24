package com.kh.workPeople.personal.mypage.interestedCompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal/mypage")
public class InterestedCompanyController {

    @GetMapping("interestedCompany")
    public void interestedCompany(){}

}
