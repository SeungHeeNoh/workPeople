package com.kh.workPeople.personal.myPage.latestPublication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal/mypage")
public class latestPublicationController {

    @GetMapping
    public void latestPublication(){}
}
