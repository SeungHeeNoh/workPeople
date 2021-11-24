package com.kh.workPeople.personal.myPage.resume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/personal/mypage")
public class resumeController {

	@GetMapping("resumeManagement")
	public void resumeManagement() {}

	@GetMapping("resumeLookUp")
	public void resumeLookUp(){}

	@GetMapping("resumeEnroll")
	public void resumeEnroll(){}
}
