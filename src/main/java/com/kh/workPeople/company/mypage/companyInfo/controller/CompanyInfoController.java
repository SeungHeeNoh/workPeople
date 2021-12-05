package com.kh.workPeople.company.mypage.companyInfo.controller;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.workPeople.common.vo.Attachment;
import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.company.mypage.companyInfo.serivce.CompanyInfoService;
import com.kh.workPeople.configuration.FileConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/company/mypage")
public class CompanyInfoController {
	
	private CompanyInfoService companyInfoService;
	
	
	@Autowired
	public CompanyInfoController(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	@GetMapping("/companyInfoInsert")
	public String companyInfo(@AuthenticationPrincipal MemberImpl user, Model model) {
		
		String userId = user.getId();
		Member meber = companyInfoService.memberInfoSelect(userId);
		
		int userNo = meber.getNo();
		CompanyInformation companyInfo = companyInfoService.companyInfoSelect(userNo);
		
		
		model.addAttribute("meber", meber);
		model.addAttribute("companyInfo", companyInfo);

		return "company/mypage/companyInfoInsert";
	}
	
	@PostMapping("/companyInfoInsert")
	public String companyInfoInsert(Member member, CompanyInformation companyInformation, RedirectAttributes rttr, 
			@RequestParam("companyNO") int companyNO, @RequestParam("userNO") int userNO) {
		
		
		member.setNo(userNO);
		companyInformation.setNo(companyNO);
		
		int result = companyInfoService.info(member, companyInformation);
		
		if (result > 0) {
			rttr.addFlashAttribute("message", "기업 정보가 변경되었습니다.");
		}
		
		return "redirect:/company/mypage/companyInfoInsert";
	}
	
	@PostMapping("/uploadFile")
	@ResponseBody
	public int uploadFile(@RequestParam MultipartFile singleFile, @RequestParam("companyNO") int companyNO) {
		
		String dir = System.getProperty("user.dir");
		
		String filePath = dir + "\\src\\main\\resources\\uploadFiles";
		String filePathDb = "/images/uploadFiles/";
		
		System.out.println("filePath : "  + filePath);
		
		File mkdir = new File(filePath);
		if (!mkdir.exists()) mkdir.mkdirs();   
	
		String originFileName = singleFile.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));  // 확장자 추출
		String savedName = UUID.randomUUID().toString().replace("-", "") + ext; 
		
		try {
			singleFile.transferTo(new File(filePath + "\\" + savedName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			new File(filePath + "\\" + savedName).delete();
		}
		
		Attachment att = new Attachment();
		att.setOriginName(originFileName);
		att.setChangeName(savedName);
		att.setFilePath(filePathDb);
		
		int result = companyInfoService.insertAttachment(att, companyNO);
		
		
		return result;
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public int deleteFile(@RequestParam("companyNO") int companyNO) {
		
		
		int result = companyInfoService.deleteFile(companyNO);
		
		return result;
	}
	

}
