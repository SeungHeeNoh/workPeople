package com.kh.workPeople.findIdPwd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/findIdPwd")
public class findIdPwdController {
	
	@GetMapping(value={"/", "main"})
	public String main() {
		return "findIdPwd/main";
	}

	@GetMapping("personal/findId")
	public String personalFindId(Model model) {
		model.addAttribute("member_type", "personal");

		return "findIdPwd/findId";
	}
	
	@GetMapping("personal/findPwd")
	public String personalFindPwd(Model model) {
		model.addAttribute("member_type", "personal");

		return "findIdPwd/findPwd";
	}
	
	@GetMapping("company/findId")
	public String companyFindId(Model model) {
		model.addAttribute("member_type", "company");

		return "findIdPwd/findId";
	}
	
	@GetMapping("company/findPwd")
	public String companyFindPwd(Model model) {
		model.addAttribute("member_type", "company");

		return "findIdPwd/findPwd";
	}
}
