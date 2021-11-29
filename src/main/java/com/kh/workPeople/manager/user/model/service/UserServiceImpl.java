package com.kh.workPeople.manager.user.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.Member;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.manager.user.model.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	private UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public Map<String, Object> ulist(int page) {
		Map<String, Object> returnMap = new HashMap<>();
		int listCount = userMapper.getListCount();
		
		PageInfo pi = new PageInfo(page, listCount, 5, 10);
		
		List<Member> userList = userMapper.selectList(pi);
		
		returnMap.put("pi", pi);
		returnMap.put("userList", userList);
		
		return returnMap;
	}

	
}