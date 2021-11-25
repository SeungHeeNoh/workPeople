package com.kh.workPeople.manager.model.vo;

import com.kh.workPeople.common.vo.Authority;

public class ManagerRole {
	private int imNo;
	private int aCode;
	private Authority authority;

	public ManagerRole() {}

	public ManagerRole(int imNo, int aCode, Authority authority) {
		super();
		this.imNo = imNo;
		this.aCode = aCode;
		this.authority = authority;
	}

	public int getImNo() {
		return imNo;
	}

	public void setImNo(int imNo) {
		this.imNo = imNo;
	}

	public int getaCode() {
		return aCode;
	}

	public void setaCode(int aCode) {
		this.aCode = aCode;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "ManagerRole [imNo=" + imNo + ", aCode=" + aCode + ", authority=" + authority + "]";
	}

	
	

}