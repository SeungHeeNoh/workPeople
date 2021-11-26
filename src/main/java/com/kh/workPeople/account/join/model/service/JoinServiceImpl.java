package com.kh.workPeople.account.join.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.workPeople.account.join.model.dao.JoinMapper;
import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberRole;
import com.kh.workPeople.common.vo.Sector;

@Service()
public class JoinServiceImpl implements JoinService {
	
	private final int CERT_LENGTH = 6; 
	private final char[] CHARACTER_TABLE = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		 								    'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
		 								    'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
	
	private PasswordEncoder passwordEncoder;
	private JoinMapper joinMapper;
	private JavaMailSender mailSender;

	@Autowired
	public JoinServiceImpl(JoinMapper joinMapper, PasswordEncoder passwordEncoder, JavaMailSender mailSender) {
		this.joinMapper = joinMapper;
		this.passwordEncoder = passwordEncoder;
		this.mailSender = mailSender;
	}

	@Override
	public int checkRegisterNumber(String registerNumber) {
		return joinMapper.checkRegisterNumber(registerNumber);
	}

	@Override
	public List<CompanyType> selectCompanyTypeList() {
		return joinMapper.selectCompanyTypeList();
	}

	@Override
	public List<Sector> selectSectorList() {
		return joinMapper.selectSectorList();
	}

	@Override
	public int checkId(String id) {
		return joinMapper.checkId(id);
	}

	@Transactional
	@Override
	public int join(Member member) {
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		MemberRole memberRole = new MemberRole();
		memberRole.setAuthorityCode(1);

		int result1 = joinMapper.insertMember(member);
		int result2 = joinMapper.insertMemberRole(memberRole);
		
		return (result1 > 0 && result2 > 0) ? 1 : 0;
	}
	
	@Transactional
	@Override
	public int join(Member member, CompanyInformation companyInformation) {
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		MemberRole memberRole = new MemberRole();
		memberRole.setAuthorityCode(2);
		
		int result1 = joinMapper.insertMember(member);
		int result2 = joinMapper.insertMemberRole(memberRole);
		int result3 = joinMapper.insertCompanyInformation(companyInformation);
		
		return (result1 > 0 && result2 > 0 && result3 > 0) ? 1 : 0;
		
	}

	@Override
	public Map<String, String> sendMail(String email) {
		Map<String, String> map = new HashMap<>();
		String certString = createCertString();
		String to = email;
		String from = "workPeople1210@gamil.com";
		String subject = "work people 회원가입 인증 이메일입니다.";
		String content = new StringBuffer().append("<h1>[이메일 인증]</h1>")
										   .append("홈페이지를 방문해주셔서 감사합니다.<br><br>")
										   .append("인증번호는" + certString +  "입니다.<br>")
										   .append("해당 인증번호를 인증번호 확인란에 기입하여 주세요.").toString();
		
		String message = "인증번호가 발송되었습니다.";

		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			
			mailHelper.setFrom(from);
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);
			
			mailSender.send(mail);
		} catch (Exception e) {
			message = "메일을 보내는 데에 실패했습니다.";
		}

		map.put("certString", certString);
		map.put("message", message);
		
		return map;
	}
	
	private String createCertString() {
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<CERT_LENGTH; i++) {
			sb.append(CHARACTER_TABLE[(int)(Math.random()*CHARACTER_TABLE.length)]);
		}
		
		return sb.toString();
	}

}
