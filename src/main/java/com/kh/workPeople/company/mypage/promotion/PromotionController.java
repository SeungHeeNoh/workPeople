package com.kh.workPeople.company.mypage.promotion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/mypage")
public class PromotionController {
	

	@GetMapping("/promotionView")
	public String promotionView() {
		return "company/mypage/promotionView";
	}
	
	@GetMapping("/paymentFinish")
	public String paymentFinish() {
		return "company/mypage/paymentFinish";
	}
	
	@GetMapping("/paidList")
	public String paidList() {
		return "company/mypage/paidList";
	}

}
