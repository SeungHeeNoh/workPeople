package com.kh.workPeople.manager.manager.model.service;

import java.util.Map;

import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.common.vo.ManagerRole;

public interface ManagerService {

	Map<String, Object> mlist(int page);

	Manager classManager(int imNo);

	int classDeleteManager(int imNo, int code);

	int classInsertManager(int imNo, int code);

	int createManager(Manager manager);

	int insertManagerRole(ManagerRole managerRole);
	
	int idOverLapCheck(String id);
	
	String encodePwd(String pwd);
	
	Manager getManagerByImId(String id);
	


}
