package com.kh.workPeople.account.login.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.login.model.dao.LoginMapper;
import com.kh.workPeople.common.vo.Authority;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberImpl;
import com.kh.workPeople.common.vo.MemberRole;

@Service
public class CompanyLoginServiceImpl implements CompanyLoginService {

	private LoginMapper loginMapper;
	
	@Autowired
	public CompanyLoginServiceImpl(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("userId", username);
		queryMap.put("memberType", 2);

		Member member = loginMapper.findMemberByIdAndMemberType(queryMap);

		if(member == null) {
			throw new UsernameNotFoundException("");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(member.getMemberRoleList() != null) {
			List<MemberRole> roleList = member.getMemberRoleList();
			
			for(MemberRole role : roleList) {
				Authority authority = role.getAuthority();
				
				if(authority != null) {
					authorities.add(new SimpleGrantedAuthority(authority.getName()));
				}
			}
		}
		MemberImpl user = new MemberImpl(member.getId(), member.getPwd(), authorities);
		user.setDetails(member);
		
		return user;
	}
}
