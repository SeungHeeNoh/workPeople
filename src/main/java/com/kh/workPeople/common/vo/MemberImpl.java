package com.kh.workPeople.common.vo;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MemberImpl extends User {
	private int no;
	private MemberType memberType;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String postCode;
	private String roadAddress;
	private String detailAddress;
	private Date enrollDate;
	private Date modifyDate;
	private int loginFailCount;
	private String isLock;
	private Date lastestTryLoginDate;
	private int lockCount;
	private String status;
	private String tempPwdYn;
	private List<MemberRole> memberRoleList;

	public MemberImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public void setDetails(Member member) {
		this.no = member.getNo();
		this.memberType = member.getMemberType();
		this.id = member.getId();
		this.pwd = member.getPwd();
		this.name = member.getName();
		this.phone = member.getPhone();
		this.email = member.getEmail();
		this.postCode = member.getPostCode();
		this.roadAddress = member.getRoadAddress();
		this.detailAddress = member.getDetailAddress();
		this.enrollDate = member.getEnrollDate();
		this.modifyDate = member.getModifyDate();
		this.loginFailCount = member.getLoginFailCount();
		this.isLock = member.getIsLock();
		this.lastestTryLoginDate = member.getLastestTryLoginDate();
		this.lockCount = member.getLockCount();
		this.status = member.getStatus();
		this.tempPwdYn = member.getTempPwdYn();
		this.memberRoleList = member.getMemberRoleList();
	}

	public int getNo() {
		return no;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public int getLoginFailCount() {
		return loginFailCount;
	}

	public String getIsLock() {
		return isLock;
	}

	public Date getLastestTryLoginDate() {
		return lastestTryLoginDate;
	}

	public int getLockCount() {
		return lockCount;
	}

	public String getStatus() {
		return status;
	}

	public String getTempPwdYn() {
		return tempPwdYn;
	}

	public List<MemberRole> getMemberRoleList() {
		return memberRoleList;
	}

	@Override
	public boolean isEnabled() {
		return this.status.equals("Y") ? true : false;
	}
	
	
}
