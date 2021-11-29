package com.kh.workPeople.company.mypage.promotion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.PromotionOrder;
import com.kh.workPeople.company.mypage.promotion.service.PromotionService;

@Controller
@RequestMapping("/company/mypage")
public class PromotionController {
	
	private PromotionService promotionService;
	
	@Autowired
	public PromotionController(PromotionService promotionService) {
		this.promotionService = promotionService;
	}

	@GetMapping("/promotionView")
	public String promotionView() {
		return "company/mypage/promotionView";
	}
	
	@GetMapping("/paymentFinish")
	public String paymentFinish() {
		return "company/mypage/paymentFinish";
	}
	
	@GetMapping("/paidDetail")
	public String paidDetail() {
		return "company/mypage/paidDetail";
	}
	
	@GetMapping("/paidList")
	public String paidList(@AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue="1") int page, Model model) {
		
		int userNo = user.getNo();
		
		Map<String, Object> map = promotionService.findList(page, userNo);
		
		model.addAttribute("orderList", map.get("orderList"));
		model.addAttribute("pi", map.get("pi"));
		model.addAttribute("using", map.get("using"));
		model.addAttribute("complete", map.get("complete"));
		
		return "company/mypage/paidList";
	}

}
