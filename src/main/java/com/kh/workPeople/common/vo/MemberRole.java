package com.kh.workPeople.common.vo;

public class MemberRole {
	private int userNo;
	private int authorityCode;
	private Authority authority;
	
	public MemberRole() {}
	
	public MemberRole(int userNo, int authorityCode, Authority authority) {
		super();
		this.userNo = userNo;
		this.authorityCode = authorityCode;
		this.authority = authority;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "MemberRole [userNo=" + userNo + ", authorityCode=" + authorityCode + ", authority=" + authority + "]";
	}
	
}
