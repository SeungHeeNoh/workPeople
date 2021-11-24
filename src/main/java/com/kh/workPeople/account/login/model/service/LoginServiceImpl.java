package com.kh.workPeople.account.login.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.workPeople.account.login.model.dao.LoginMapper;
import com.kh.workPeople.common.vo.Authority;
import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.MemberRole;
import com.kh.workPeople.common.vo.UserImpl;


@Service
public class LoginServiceImpl implements LoginService {
	
	private LoginMapper loginMapper;
	
	@Autowired
	public LoginServiceImpl(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member member = loginMapper.findMemberById(username);
		
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
		UserImpl user = new UserImpl(member.getId(), member.getPwd(), authorities);
		user.setDetails(member);
		
		return user;
	}
	
	@Override
	public Member findMemberById(String id) {
		return loginMapper.findMemberById(id);
	}

	@Override
	public int updateLoginInformation(UserImpl userImpl) {
		int result = loginMapper.updateLoginInformation(userImpl);
		return result;
	}

	@Override
	public void updateFailureCount(String id) {
		loginMapper.updateFailureCount(id);
	}

	@Override
	public void updateAccountLock(String id) {
		loginMapper.updateAccountLock(id);
		
	}

}
