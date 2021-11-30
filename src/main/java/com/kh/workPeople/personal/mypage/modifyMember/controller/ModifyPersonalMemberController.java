package com.kh.workPeople.personal.mypage.modifyMember.controller;

import com.kh.workPeople.common.vo.MemberImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/personal/mypage")
public class ModifyPersonalMemberController {





    @GetMapping("modifyMember")
    public String ModifyPersonalMember(){


        return "personal/mypage/memberInfoPwd";
    }


    @GetMapping("outOfMember")
    public String OutOfPersonalMember(){




        return "personal/mypage/outOfMember";
    }




}
