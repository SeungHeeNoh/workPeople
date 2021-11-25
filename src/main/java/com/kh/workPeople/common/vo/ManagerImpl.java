package com.kh.workPeople.common.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.kh.workPeople.manager.model.vo.Manager;
import com.kh.workPeople.manager.model.vo.ManagerRole;

public class ManagerImpl extends User {
	private int imNo;
	private String imId;
	private String imPwd;
	private String imName;
	private List<ManagerRole> managerRoleList;
	private int managerRole;
	
	public ManagerImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public void setDetails(Manager manager) {
		this.imNo = manager.getImNo();
		this.imId = manager.getImId();
		this.imPwd = manager.getImPwd();
		this.imName = manager.getImName();
		this.managerRoleList = manager.getManagerRoleList();
	}

	public int getImNo() {
		return imNo;
	}

	public void setImNo(int imNo) {
		this.imNo = imNo;
	}

	public String getImId() {
		return imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public String getImPwd() {
		return imPwd;
	}

	public void setImPwd(String imPwd) {
		this.imPwd = imPwd;
	}

	public String getImName() {
		return imName;
	}

	public void setImName(String imName) {
		this.imName = imName;
	}

	public List<ManagerRole> getManagerRoleList() {
		return managerRoleList;
	}

	public void setManagerRoleList(List<ManagerRole> managerRoleList) {
		this.managerRoleList = managerRoleList;
	}

	public int getManagerRole() {
		return managerRole;
	}

	public void setManagerRole(int managerRole) {
		this.managerRole = managerRole;
	}
	
}
