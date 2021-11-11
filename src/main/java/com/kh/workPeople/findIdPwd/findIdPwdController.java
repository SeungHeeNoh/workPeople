package com.kh.workPeople.findIdPwd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/findIdPwd")
public class findIdPwdController {
	
	@GetMapping(value={"/", "main"})
	public String main() {
		return "findIdPwd/main";
	}


}
