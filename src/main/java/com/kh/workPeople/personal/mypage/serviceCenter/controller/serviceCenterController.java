package com.kh.workPeople.personal.mypage.serviceCenter.controller;

import com.kh.workPeople.common.vo.ChatRoom;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.personal.mypage.serviceCenter.model.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("personal/mypage")
public class serviceCenterController {

    private final ChatService chatService;

    @Autowired
    public serviceCenterController(ChatService chatService){
        this.chatService=chatService;
    }

    /* 채팅방 생성 */
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

        // 채팅방 생성
       ChatRoom chatRoom = chatService.createChatRoom(user.getName());

        return "redirect:/personal/mypage/serviceCenter/"+chatRoom.getId();
    }

    // 특정 채팅방 입장
    @GetMapping("/serviceCenter/{id}")
    public String chatRoomEnter(HttpServletRequest request,@PathVariable String id, Model model,@AuthenticationPrincipal MemberImpl user){

        String host = request.getRemoteAddr();
        model.addAttribute("host",host);
        System.out.println("host"+host);

        ChatRoom room = chatService.findChatRoomById(id);
        String userName = user.getName();
        model.addAttribute("room",room);
        model.addAttribute("userName",userName);


        return "personal/mypage/serviceCenter";
    }





}
