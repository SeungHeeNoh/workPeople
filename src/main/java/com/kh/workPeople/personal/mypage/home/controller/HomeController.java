package com.kh.workPeople.personal.mypage.home.controller;

import com.kh.workPeople.common.vo.JobVacancyLookUp;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.Resume;
import com.kh.workPeople.common.vo.ResumeBrowseCompany;
import com.kh.workPeople.personal.mypage.applyCompany.model.service.ApplyCompanyService;
import com.kh.workPeople.personal.mypage.home.model.service.HomeService;
import com.kh.workPeople.personal.mypage.resumeBrowseCompany.model.service.ResumeBrowseCompanyService;
import com.kh.workPeople.personal.mypage.scrap.model.service.ScrapService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/personal/mypage")
public class HomeController {

	private final HomeService homeService;
	private final ApplyCompanyService applyCompanyService;
	private final ResumeBrowseCompanyService resumeBrowseCompanyService;
	private final ScrapService scrapService;

	@Autowired
	public HomeController(ScrapService scrapService,HomeService homeService, ApplyCompanyService applyCompanyService,ResumeBrowseCompanyService resumeBrowseCompanyService) {
		this.homeService = homeService;
		this.applyCompanyService = applyCompanyService;
		this.resumeBrowseCompanyService = resumeBrowseCompanyService;
		this.scrapService = scrapService;
	}

	@GetMapping("home")
	public String mypageHome(Model model, @AuthenticationPrincipal MemberImpl user, @RequestParam(defaultValue = "1") int page) {

		int applyCount = homeService.applyCount(user.getNo());
		int resumeBrowseCount = homeService.resumeBrowseCount(user.getNo());
		int scrapCount = homeService.scrapCount(user.getNo());
		int interestedCompanyCount = homeService.interestedCompanyCount(user.getNo());
		int chatCount = homeService.chatCount(user.getNo());

		model.addAttribute("applyCount",applyCount);
		model.addAttribute("resumeBrowseCount",resumeBrowseCount);
		model.addAttribute("scrapCount",scrapCount);
		model.addAttribute("interestedCompanyCount",interestedCompanyCount);
		model.addAttribute("chatCount",chatCount);


		List<JobVacancyLookUp> applyCompanyList = applyCompanyService.jobVacancyLookUpList(user.getNo());


		List<JobVacancyLookUp> applyCompanyList1 = new ArrayList<>(3);
		List<JobVacancyLookUp> applyCompanyList2 = new ArrayList<>(3);
		List<JobVacancyLookUp> applyCompanyList3 = new ArrayList<>(3);

		int jobResult=0;
		for(JobVacancyLookUp job : applyCompanyList){

			if(jobResult<3){
				applyCompanyList1.add(job);
				jobResult++;
			} else if(jobResult<6){
				applyCompanyList2.add(job);
				jobResult++;
			} else if(jobResult<9){
				applyCompanyList3.add(job);
				jobResult++;
			}
		}
		model.addAttribute("applyCompanyList1",applyCompanyList1);
		model.addAttribute("applyCompanyList2",applyCompanyList2);
		model.addAttribute("applyCompanyList3",applyCompanyList3);


		List<ResumeBrowseCompany> resumeBrowseList = resumeBrowseCompanyService.selectResumeBrowseCompanyList(user.getNo());

		List<ResumeBrowseCompany> resumeBrowseList1 = new ArrayList<>(3);
		List<ResumeBrowseCompany> resumeBrowseList2 = new ArrayList<>(3);
		List<ResumeBrowseCompany> resumeBrowseList3 = new ArrayList<>(3);

		int rbcResult = 0;
		for(ResumeBrowseCompany rbc : resumeBrowseList){
			if(rbcResult<3){
				resumeBrowseList1.add(rbc);
				rbcResult++;
			} else if(rbcResult<6){
				resumeBrowseList2.add(rbc);
				rbcResult++;
			} else if(rbcResult<9){
				resumeBrowseList3.add(rbc);
				rbcResult++;
			}
		}
		model.addAttribute("resumeBrowseList1",resumeBrowseList1);
		model.addAttribute("resumeBrowseList2",resumeBrowseList2);
		model.addAttribute("resumeBrowseList3",resumeBrowseList3);


		List<JobVacancyLookUp> scrapList = scrapService.jobVacancyLookUpList(user.getNo());

		List<JobVacancyLookUp> scrapList1 = new ArrayList<>(3);
		List<JobVacancyLookUp> scrapList2 = new ArrayList<>(3);
		List<JobVacancyLookUp> scrapList3 = new ArrayList<>(3);

		int scrapResult = 0;
		for(JobVacancyLookUp scrap : scrapList){
			if(scrapResult<3){
				scrapList1.add(scrap);
				scrapResult++;
			} else if(scrapResult<6){
				scrapList2.add(scrap);
				scrapResult++;
			} else if(scrapResult<9){
				scrapList3.add(scrap);
				scrapResult++;
			}
		}
		model.addAttribute("scrapList1",scrapList1);
		model.addAttribute("scrapList2",scrapList2);
		model.addAttribute("scrapList3",scrapList3);






		Resume resume = homeService.selectResumeStatusY(user.getNo());
		String elName = null;

		if(resume != null) {
			Date beforeDate = resume.getEnrollDate();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.dd");
			String afterDate = simpleDateFormat.format(beforeDate);
			elName = resume.getS_name();
			model.addAttribute("resumeEnrollDate", afterDate);
			model.addAttribute("resume", resume);
		}


		Map<String, Object> recommendMap = homeService.recommenedJobVacancyListPaging(elName,page);

		List<JobVacancyLookUp> jobVacancyLookUpList = (List<JobVacancyLookUp>)recommendMap.get("jobVacancyLookUpList");

//		List<JobVacancyLookUp> jobVacancyLookUpList = homeService.recommenedJobVacancyList(elName);

		for(JobVacancyLookUp job : jobVacancyLookUpList){
			int applyCompanyYN = homeService.applyCompanyYN(user.getNo(),job.getJvNo());

			if(applyCompanyYN > 0){
				job.setApplyYN(true);
			} else{
				job.setApplyYN(false);
			}
		}

		model.addAttribute("jobVacancyLookUpList",jobVacancyLookUpList);
		model.addAttribute("pi",recommendMap.get("pi"));

		return "personal/mypage/home";
	}

	@GetMapping("home/resumeEdit/{rNo}")
	public String resumeEdit(@PathVariable int rNo, Model model, @AuthenticationPrincipal MemberImpl user){




		return "personal/mypage/resumeEdit";
	}

	@GetMapping("home/resumeDelete/{rNo}")
	public String resumeDelete(@PathVariable int rNo, Model model, @AuthenticationPrincipal MemberImpl user){

		int resumeIsApplyCompanyYN = homeService.resumeIsApplyCompanyYN(rNo);

		if(resumeIsApplyCompanyYN > 0){
			int resumeDelete = homeService.resumeDelete(rNo);
		} else{
			int basicInfoDeleteFromDB = homeService.basicInfoDeleteFromDB(rNo);
			int educationDeleteFromDB = homeService.educationDeleteFromDB(rNo);
			int careerDeleteFromDB = homeService.careerDeleteFromDB(rNo);
			int activityDeleteFromDB = homeService.activityDeleteFromDB(rNo);
			int licenseDeleteFromDB = homeService.licenseDeleteFromDB(rNo);
			int languageDeleteFromDB = homeService.languageDeleteFromDB(rNo);
			int awardsDeleteFromDB = homeService.awardsDeleteFromDB(rNo);
			int selfIntroductionDeleteFromDB = homeService.selfIntroductionDeleteFromDB(rNo);
			int resumeBrowseDeleteFromDB = homeService.resumeBrowseDeleteFromDB(rNo);
			int resumeDeleteFromDB = homeService.resumeDeleteFromDB(rNo);
		}

		return "redirect:/personal/mypage/home";
	}

	@GetMapping("home/applyResume/{rNo},{applyBtnNo}")
	public String applyResume(@PathVariable int rNo, @PathVariable int applyBtnNo, RedirectAttributes rttr){

		int applyCompany = applyCompanyService.applyCompany(rNo,applyBtnNo);

		if(applyCompany>0){
			return "redirect:/personal/mypage/home";
		} else{
			rttr.addFlashAttribute("errorMessage","입사지원에 실패하셨습니다.");
			return "redirect:/common/errorPage";
		}


	}





















}
	
