package com.kh.workPeople.personal.mypage.serviceCenter.controller;

import com.kh.workPeople.common.vo.MemberImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("personal/mypage")
public class serviceCenterController {

    @GetMapping("serviceCenter")
    public String serviceCenter(Model model, @AuthenticationPrincipal MemberImpl user, HttpSession session, HttpServletRequest request){

        String username = user.getName();
        model.addAttribute("username",username);
        session.setAttribute("username",username);

        log.info("고객의 대화명 : {}",username);

        // ip저장
        String host = request.getRemoteAddr();
        model.addAttribute("host",host);
        log.info("host 주소 : {}",host);

        return "personal/mypage/serviceCenter";
    }
}
