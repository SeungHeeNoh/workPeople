package com.kh.workPeople.common.vo;

import java.util.List;

public class Manager {
	private int imNo;
	private String imId;
	private String imPwd;
	private String imName;
	private List<ManagerRole> managerRoleList;
	
	public Manager() {}

	public Manager(int imNo, String imId, String imPwd, String imName, List<ManagerRole> managerRoleList) {
		super();
		this.imNo = imNo;
		this.imId = imId;
		this.imPwd = imPwd;
		this.imName = imName;
		this.managerRoleList = managerRoleList;
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

	@Override
	public String toString() {
		return "Manager [imNo=" + imNo + ", imId=" + imId + ", imPwd=" + imPwd + ", imName=" + imName
				+ ", managerRoleList=" + managerRoleList + "]";
	}
	
	
}
