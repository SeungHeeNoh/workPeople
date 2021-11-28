package com.kh.workPeople.account.findIdPwd.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.findIdPwd.model.dao.FindIdPwdMapper;
import com.kh.workPeople.common.vo.Member;

@Service
@PropertySource("classpath:application.yml")
public class FindIdPwdServiceImpl implements FindIdPwdService {
	
	private final int PASSWORD_LENGTH = 8; 
	private final char[] CHARACTER_TABLE = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
            								 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            								 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            								 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
            								 'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&', '*',
            								 '(', ')', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };


	@Value("${mail.gmail.username}")
	private String username;
	private FindIdPwdMapper findIdPwdMapper;
	private JavaMailSender mailSender;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public FindIdPwdServiceImpl(FindIdPwdMapper findIdPwdMapper, JavaMailSender mailSender, PasswordEncoder passwordEncoder) {
		this.findIdPwdMapper = findIdPwdMapper;
		this.mailSender = mailSender;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Member findMemberForId(Map<String, String> input) {
		return findIdPwdMapper.findMemberForId(input);
	}
	
	@Override
	public Member findMemberForPwd(Map<String, String> input) {
		return findIdPwdMapper.findMemberForPwd(input);
	}

	@Override
	public int sendMail(Member member) {
		String to = member.getEmail();
		String from = username;
		String subject = "[Work People] 아이디 찾기 이메일입니다.";
		String content = new StringBuffer().append("<h1>[아이디 찾기]</h1>")
										   .append("안녕하세요. Work People 입니다.<br>")
										   .append("고객님의 아이디는 " + member.getId() + " 입니다.<br>").toString();
		int result = 0;
		
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

			mailHelper.setFrom(from);
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);

			mailSender.send(mail);
			result = 1;
		} catch (Exception e) {
			result = 0;
		}

		return result;
	}

	@Override
	public int sendTempPwdMail(Member member) {
		String tempPassword = createTempPassword();
		String to = member.getEmail();
		String from = username;
		String subject = "[Work People] 비밀번호 찾기 이메일입니다.";
		String content = new StringBuffer().append("<h1>[임시 비밀번호 발급]</h1>")
										   .append("안녕하세요. Work People 입니다.<br>")
										   .append("고객님의 임시 비밀번호는 " + tempPassword + " 입니다.<br>").toString();
		int result = 0;
		
		member.setPwd(passwordEncoder.encode(tempPassword));
		
		if(findIdPwdMapper.updateTempPassword(member) == 1) {
			try {
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

				mailHelper.setFrom(from);
				mailHelper.setTo(to);
				mailHelper.setSubject(subject);
				mailHelper.setText(content, true);

				mailSender.send(mail);
				result = 1;
			} catch (Exception e) {
				result = 0;
			}	
		}

		return result;
	}

	private String createTempPassword() {
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<PASSWORD_LENGTH; i++) {
			sb.append(CHARACTER_TABLE[(int)(Math.random()*CHARACTER_TABLE.length)]);
		}
		
		return sb.toString();
	}

}
