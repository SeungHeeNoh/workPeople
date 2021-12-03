package com.kh.workPeople.personal.mypage.modifyMember.controller;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.company.mypage.memberInfo.service.MemberInfoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Slf4j
@Controller
@RequestMapping("/personal/mypage")
public class ModifyPersonalMemberController {

   private final MemberInfoService memberInfoService;
   private final PasswordEncoder passwordEncoder;

   @Autowired
   public ModifyPersonalMemberController(MemberInfoService memberInfoService,PasswordEncoder passwordEncoder){
       this.memberInfoService = memberInfoService;
       this.passwordEncoder = passwordEncoder;
   }

   // snb에서 회원정보수정 눌렀을 때 비밀번호 확인 페이지
   @GetMapping("memberInfoPwd")
   public String personalMemberPwd(Model model, @AuthenticationPrincipal MemberImpl user){

       model.addAttribute("member",user);

       log.info("memberPwd : " + user.getPwd());

       return "personal/mypage/memberInfoPwd";
   }

    // 회원정보 수정 -비밀번호 확인 - 비밀번호가 일치할 때 회원정보 수정 페이지
    @GetMapping("memberInfoUpdate")
    public String memberUpdate(Model model, @AuthenticationPrincipal MemberImpl user) {

        model.addAttribute("member", user);

        System.out.println(user);

        log.info("memberInfo : " + user.getPwd());

        return "personal/mypage/memberInfoUpdate";
    }

    // 회원탈퇴
    @GetMapping("memberleave")
    public String memberLeave(Model model, @AuthenticationPrincipal MemberImpl user) {

        model.addAttribute("member", user);

        return "personal/mypage/memberleave";
    }

    @PostMapping("memberleave")
    public String leave(@AuthenticationPrincipal MemberImpl user) {

        int result = memberInfoService.leave(user);

        return "redirect:/account/manager/logout";
    }

    // 회원정보 수정 -비밀번호 확인 페이지 - 비밀번호 입력후 확인 눌렀을 때
    @PostMapping("pwdCheck")
    public String pwdCheck(@RequestParam("password") String password, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr){

        log.info("비밀번호 확인 요청 발생!!");

        String result;

        if (passwordEncoder.matches(password, user.getPwd())) {
            result = "redirect:/personal/mypage/memberInfoUpdate";
        } else {
            rttr.addFlashAttribute("message", "비밀번호가 일치하지 않습니다.");
            result = "redirect:/personal/mypage/memberInfoPwd";
        }

        return result;
    }

    // 회원정보수정 페이지에서 회원정보수정 버튼 클릭시
    @PostMapping("memberInfoUpdate")
    public String updateInfo(Member member,RedirectAttributes rttr, @AuthenticationPrincipal MemberImpl user){

        String result;
        int result2 = 0;
        int result1 = memberInfoService.updatePersonalInfo(member);

        if(member.getPwd() != "") {
            result2 = memberInfoService.updatePwd(member);
        }

        Member mem = memberInfoService.selectAll(member);

        user.setDetails(mem);

        if (result1 > 0) {
            System.out.println("회원 정보가 변경되었습니다.");
            rttr.addFlashAttribute("message", "회원 정보가 변경되었습니다.");
            result = "redirect:/personal/mypage/memberInfoUpdate";
        } else {
            System.out.println("에러가 발생헀습니다.");
            rttr.addFlashAttribute("message", "에러가 발생헀습니다.");
            result = "redirect:/common/errorPage";
        }

       return result;
    }

    @PostMapping("leaveCheckPwd")
    @ResponseBody
    public int deleteFile(@RequestParam("password") String password, @AuthenticationPrincipal MemberImpl user) {


        return passwordEncoder.matches(password, user.getPwd()) ? 1 : 0;
    }

















}
