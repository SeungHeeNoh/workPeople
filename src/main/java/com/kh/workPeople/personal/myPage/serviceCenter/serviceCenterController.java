package com.kh.workPeople.personal.myPage.serviceCenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("personal/mypage")
public class serviceCenterController {

    @GetMapping("serviceCenter")
    public void serviceCenter(){}
}
