package com.kh.workPeople.manager.user.controller;

import java.util.Map;

import com.kh.workPeople.common.vo.ChatRoom;
import com.kh.workPeople.personal.mypage.serviceCenter.model.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.workPeople.manager.user.model.service.UserService;



@Controller
@RequestMapping("/manager/user")
public class UserController {

	private final UserService userService;
	private final ChatService chatService;

	@Autowired
	public UserController(UserService userService,ChatService chatService){
		this.userService = userService;
		this.chatService = chatService;
	}
	
		@GetMapping("/userinfo")
		public ModelAndView userList(ModelAndView mv, @RequestParam(defaultValue="1") int page) {
			Map<String, Object> map = userService.ulist(page);
			
			mv.addObject("userList", map.get("userList"));
			mv.addObject("pi", map.get("pi"));
			mv.setViewName("manager/user/userinfo");
			
			
			return mv;
		}

		// 모든 채팅방 조회
		@GetMapping("/customerservice")
		public String userCustomerService(Model model) {


			model.addAttribute("roomList",chatService.findAllChatRoom());

			return "manager/user/customerservice";
		}

	@GetMapping("/serviceCenter/{id}")
	public String chatRoomEnter(@PathVariable String id, Model model){

		ChatRoom room = chatService.findChatRoomById(id);
		model.addAttribute("room",room);


		return "personal/mypage/serviceCenter";
	}



		// 특정 채팅방 입장
//	@GetMapping("/customerservice/{id}")
//		public String chatRoomEnter(@PathVariable String id, Model model){
//
//			ChatRoom room = chatService.findChatRoomById(id);
//			model.addAttribute("room",room);
//
//			return "personal/mypage/serviceCenter";
//		}
	
	}
