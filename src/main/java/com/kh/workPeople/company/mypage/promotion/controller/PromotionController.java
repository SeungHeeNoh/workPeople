package com.kh.workPeople.company.mypage.promotion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
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
	public String promotionView(@AuthenticationPrincipal MemberImpl user, Model model) {
		
		int userNo = user.getNo();
		
		int cino = promotionService.selectcino(userNo);
		
	    List<JobVacancyLookUp> jobList = promotionService.selectAllJob(cino);
		
	    
	    model.addAttribute("user", user);
	    model.addAttribute("jobList", jobList);
		
		return "company/mypage/promotionView";
	}
	
	@GetMapping("/paymentFinish")
	public String paymentFinish() {
		return "company/mypage/paymentFinish";
	}
	
	@GetMapping("/paidDetail")
	public String paidDetail(@RequestParam("pno") int pno, Model model) {
		
		
		PromotionOrder order = promotionService.selectOrder(pno);
		
		model.addAttribute("order", order);
		
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
	
	@PostMapping("/payment")
	@ResponseBody
	public int payment(@RequestBody Map<String, Object> map, @AuthenticationPrincipal MemberImpl user) throws ParseException{
		
		int userNo = user.getNo();
		
		int date = Integer.parseInt(String.valueOf(map.get("date")));
		String startDate = (String) map.get("startDate");
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date to = fm.parse(startDate);
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(to);
		cal.add(Calendar.DATE, date);
		Date endDate = cal.getTime();
		
		map.put("userNo", userNo);
		map.put("newStartDate", to);
		map.put("endDate", endDate);
		
		int result = promotionService.insertPayment(map);
	
		return result;
	}

}
