package com.kh.workPeople.mail.model.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.kh.workPeople.mail.model.vo.Mail;

@Service
public class MailServiceImpl implements MailService {
	
	private JavaMailSender mailSender;
	
	@Autowired
	public MailServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public int sendMail(Mail mail) {
		int result = 0;
		
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

			mailHelper.setFrom(mail.getFrom());
			mailHelper.setTo(mail.getTo());
			mailHelper.setSubject(mail.getSubject());
			mailHelper.setText(mail.getContent(), true);

			mailSender.send(mimeMessage);
			result = 1;
		} catch (Exception e) {
			result = 0;
		}
		
		return result;
	}

}
