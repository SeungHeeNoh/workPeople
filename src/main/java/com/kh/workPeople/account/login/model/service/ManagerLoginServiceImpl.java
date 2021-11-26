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
import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.common.vo.ManagerImpl;
import com.kh.workPeople.common.vo.ManagerRole;

@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {
	
	private LoginMapper loginMapper;
	
	@Autowired
	public ManagerLoginServiceImpl(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Manager manager = loginMapper.findManagerById(username);

		if(manager == null) {
			throw new UsernameNotFoundException("");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();

		if(manager.getManagerRoleList() != null) {
			List<ManagerRole> roleList = manager.getManagerRoleList();
			
			for(ManagerRole role : roleList) {
				Authority authority = role.getAuthority();
				
				if(authority != null) {
					authorities.add(new SimpleGrantedAuthority(authority.getName()));
				}
			}
		}

		ManagerImpl user = new ManagerImpl(manager.getImId(), manager.getImPwd(), authorities);
		user.setDetails(manager);
		
		return user;
	}

}
