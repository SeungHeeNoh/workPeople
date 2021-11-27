package com.kh.workPeople.account.findIdPwd.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.findIdPwd.model.dao.FindIdPwdMapper;

@Service
@PropertySource("classpath:application.yml")
public class FindIdPwdServiceImpl implements FindIdPwdService {

	@Value("${mail.gmail.username}")
	private String username;
	private FindIdPwdMapper findIdPwdMapper;
	private JavaMailSender mailSender;
	
	@Autowired
	public FindIdPwdServiceImpl(FindIdPwdMapper findIdPwdMapper, JavaMailSender mailSender) {
		this.findIdPwdMapper = findIdPwdMapper;
		this.mailSender = mailSender;
	}

	@Override
	public String findPersonalId(Map<String, String> input) {
		return findIdPwdMapper.findPersonalId(input);
	}

	@Override
	public int sendMail(String email, String id) {
		Map<String, String> map = new HashMap<>();
		String to = email;
		String from = username;
		String subject = "[Work People] 아이디 찾기 이메일입니다.";
		String content = new StringBuffer().append("<h1>[아이디 찾기]</h1>")
										   .append("안녕하세요. Work People 입니다.<br>")
										   .append("고객님의 아이디는 " + id + " 입니다.<br>").toString();
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
	public String findCompanyId(Map<String, String> input) {
		return findIdPwdMapper.findCompanyId(input);
	}

}
