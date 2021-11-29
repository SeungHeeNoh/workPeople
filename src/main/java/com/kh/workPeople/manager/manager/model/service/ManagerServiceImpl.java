package com.kh.workPeople.manager.manager.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.common.vo.ManagerRole;
import com.kh.workPeople.common.vo.PageInfo;
import com.kh.workPeople.manager.manager.model.dao.ManagerMapper;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	private ManagerMapper managerMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public ManagerServiceImpl(ManagerMapper managerMapper, PasswordEncoder passwordEncoder) {
		this.managerMapper = managerMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Map<String, Object> mlist(int page) {
		Map<String, Object> returnMap = new HashMap<>();
		int listCount = managerMapper.getListCount();
		
		PageInfo pi = new PageInfo(page, listCount, 5, 10);
		
		List<Manager> managerList = managerMapper.selectList(pi);
		
		returnMap.put("pi", pi);
		returnMap.put("managerList", managerList);
		
		return returnMap;
	}

	@Override
	public Manager classManager(int imNo) {
		return managerMapper.classManager(imNo);
	}

	@Override
	public int classDeleteManager(int imNo, int code) {
		return managerMapper.classDeleteManager(imNo, code);
	}

	@Override
	public int classInsertManager(int imNo, int code) {
		return managerMapper.classInsertManager(imNo, code);
	}

	@Override
	public int createManager(Manager manager) {
		return managerMapper.createManager(manager);
	}

	@Override
	public int insertManagerRole(ManagerRole managerRole) {
		return managerMapper.insertManagerRole(managerRole);
	}
	
	@Override
	public int idOverLapCheck(String id) {
		return managerMapper.idOverlapCheck(id);
	}
	@Override
	public String encodePwd(String pwd) {
		return 	passwordEncoder.encode(pwd);
	}

	@Override
	public Manager getManagerByImId(String id) {
		return managerMapper.getManagerByImId(id);
	}
	
	
}