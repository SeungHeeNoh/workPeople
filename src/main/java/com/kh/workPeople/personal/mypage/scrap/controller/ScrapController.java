package com.kh.workPeople.personal.mypage.scrap.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kh.workPeople.common.vo.*;
import com.kh.workPeople.personal.mypage.resume.model.dao.ResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.kh.workPeople.personal.mypage.scrap.model.service.ScrapService;

@Controller
@RequestMapping("/personal/mypage")
public class ScrapController {

	private final ScrapService scrapService;
	private final HomeService homeService;
	private final ApplyCompanyService applyCompanyService;
	private final ResumeMapper resumeMapper;

	@Autowired
	public ScrapController(ResumeMapper resumeMapper,ScrapService scrapService, HomeService homeService, ApplyCompanyService applyCompanyService) {
		this.scrapService = scrapService;
		this.homeService=homeService;
		this.applyCompanyService = applyCompanyService;
		this.resumeMapper = resumeMapper;
	}

	@GetMapping("scrap")
	public String scrap(Model model, @AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue = "1") int page) {

		Map<String, Object> scrapMap = scrapService.jobVacancyLookUpListPaging(user.getNo(),page);

		List<JobVacancyLookUp> jobVacancyLookUpList = (List<JobVacancyLookUp>)scrapMap.get("jobVacancyLookUpList");

		for(JobVacancyLookUp job : jobVacancyLookUpList){
			int applyCompanyYN = homeService.applyCompanyYN(user.getNo(),job.getJvNo());

			if(applyCompanyYN > 0){
				job.setApplyYN(true);
			} else{
				job.setApplyYN(false);
			}
		}
//
		model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);
		model.addAttribute("pi",scrapMap.get("pi"));
//
		Resume resume = homeService.selectResumeStatusY(user.getNo());
		if(resume != null){
			model.addAttribute("resume",resume);
			model.addAttribute("resumeNo",resume.getNo());
		}
//
		return "personal/mypage/scrap";
//		return null;
	}

	@GetMapping("scrap/applyResume/{rNo},{applyBtnNo}")
	public String applyResume(@PathVariable int applyBtnNo, Model model, @AuthenticationPrincipal MemberImpl user){

		int rNo = user.getNo();
		//입사지원 테이블 삽입
		int applyCompany = applyCompanyService.applyCompany(user.getNo(),applyBtnNo);
		// 입사지원한 이력서 테이블에 삽입
		int appliedInsertCompany = applyCompanyService.insertAppliedTable(user.getNo(),applyBtnNo);

		return "redirect:/personal/mypage/scrap";
	}
	
	@PostMapping("/scrap/list/delete")
	public String deleteScrapList(@RequestParam("jvNo") List<Integer> jvNoList, @AuthenticationPrincipal MemberImpl user, RedirectAttributes rttr, HttpServletRequest request) {
		Map<String, Object> queryMap = new HashMap<>();
		int result = 0;

		queryMap.put("userNo", user.getNo());
		queryMap.put("jvNoList", jvNoList);
		
		result = scrapService.deleteScrapList(queryMap);
		
		if(result > 0) {
			rttr.addFlashAttribute("message", "선택하신 스크랩 공고 목록 삭제에 성공했습니다.");
			return "redirect:/personal/mypage/scrap";
		} else {
			request.setAttribute("errorMessage", "선택하신 스크랩 공고 목록 삭제에 실패했습니다.");
			return "/common/errorPage";
		}
	}

	@PostMapping("/scrap/job-vacancy/{jobVacancyNo}")
	@ResponseBody
	public Map<String, Object> insertScrap(@PathVariable int jobVacancyNo, @AuthenticationPrincipal MemberImpl user) {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Integer> queryMap = new HashMap<>();
		String message = "";
		
		queryMap.put("userNo", user.getNo());
		queryMap.put("jobVacancyNo", jobVacancyNo);
		
		int result = scrapService.insertScrap(queryMap);
		
		if(result > 0) {
			message = "success";
		}
		
		return resultMap;
	}

	@DeleteMapping("/scrap/job-vacancy/{jobVacancyNo}")
	@ResponseBody
	public Map<String, Object> deleteScrap(@PathVariable int jobVacancyNo, @AuthenticationPrincipal MemberImpl user) {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Integer> queryMap = new HashMap<>();
		String message = "";
		
		queryMap.put("userNo", user.getNo());
		queryMap.put("jobVacancyNo", jobVacancyNo);
		
		int result = scrapService.deleteScrap(queryMap);
		
		if(result > 0) {
			message = "success";
		}
		
		return resultMap;
	}
}
