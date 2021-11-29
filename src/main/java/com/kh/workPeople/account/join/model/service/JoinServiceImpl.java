package com.kh.workPeople.account.join.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.workPeople.account.join.model.dao.JoinMapper;
import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.CompanyType;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberRole;
import com.kh.workPeople.common.vo.Sector;
import com.kh.workPeople.mail.model.service.MailService;
import com.kh.workPeople.mail.model.vo.Mail;

@Service
@PropertySource("classpath:application.yml")
public class JoinServiceImpl implements JoinService {
	
	private final int CERT_LENGTH = 6; 
	private final char[] CHARACTER_TABLE = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		 								    'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
		 								    'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
	
	@Value("${mail.gmail.username}")
	private String username;
	private PasswordEncoder passwordEncoder;
	private JoinMapper joinMapper;
	private MailService mailService;

	@Autowired
	public JoinServiceImpl(JoinMapper joinMapper, MailService mailService, PasswordEncoder passwordEncoder) {
		this.joinMapper = joinMapper;
		this.mailService = mailService;
		this.passwordEncoder = passwordEncoder;
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
	public String sendCertifyMail(String email) {
		String certString = createCertString();
		String content = new StringBuffer().append("<h1>[이메일 인증]</h1>")
										   .append("홈페이지를 방문해주셔서 감사합니다.<br><br>")
										   .append("인증번호는" + certString +  "입니다.<br>")
										   .append("해당 인증번호를 인증번호 확인란에 기입하여 주세요.").toString();

		Mail mail = new Mail();
		mail.setFrom(username);
		mail.setTo(email);
		mail.setSubject("[Work People] 회원가입 인증 이메일입니다.");
		mail.setContent(content);
		
		if(mailService.sendMail(mail) == 0) {
			certString = "";
		}

		return certString;
	}
	
	private String createCertString() {
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<CERT_LENGTH; i++) {
			sb.append(CHARACTER_TABLE[(int)(Math.random()*CHARACTER_TABLE.length)]);
		}
		
		return sb.toString();
	}

}
