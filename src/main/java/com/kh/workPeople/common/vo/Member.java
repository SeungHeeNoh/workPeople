package com.kh.workPeople.common.vo;

import java.util.Date;
import java.util.List;

public class Member {
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
	private String enrollDateformat;
	
	
	public Member() {}

	public Member(int no, MemberType memberType, String id, String pwd, String name, String phone, String email,
			String postCode, String roadAddress, String detailAddress, Date enrollDate, Date modifyDate,
			int loginFailCount, String isLock, Date lastestTryLoginDate, int lockCount, String status, String tempPwdYn,
			List<MemberRole> memberRoleList) {
		super();
		this.no = no;
		this.memberType = memberType;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.postCode = postCode;
		this.roadAddress = roadAddress;
		this.detailAddress = detailAddress;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.loginFailCount = loginFailCount;
		this.isLock = isLock;
		this.lastestTryLoginDate = lastestTryLoginDate;
		this.lockCount = lockCount;
		this.status = status;
		this.tempPwdYn = tempPwdYn;
		this.memberRoleList = memberRoleList;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(int loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public String getIsLock() {
		return isLock;
	}

	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}

	public Date getLastestTryLoginDate() {
		return lastestTryLoginDate;
	}

	public void setLastestTryLoginDate(Date lastestTryLoginDate) {
		this.lastestTryLoginDate = lastestTryLoginDate;
	}

	public int getLockCount() {
		return lockCount;
	}

	public void setLockCount(int lockCount) {
		this.lockCount = lockCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTempPwdYn() {
		return tempPwdYn;
	}

	public void setTempPwdYn(String tempPwdYn) {
		this.tempPwdYn = tempPwdYn;
	}

	public List<MemberRole> getMemberRoleList() {
		return memberRoleList;
	}

	public void setMemberRoleList(List<MemberRole> memberRoleList) {
		this.memberRoleList = memberRoleList;
	}
	
	

	public String getEnrollDateformat() {
		return enrollDateformat;
	}

	public void setEnrollDateformat(String enrollDateformat) {
		this.enrollDateformat = enrollDateformat;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", memberType=" + memberType + ", id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", phone=" + phone + ", email=" + email + ", postCode=" + postCode + ", roadAddress=" + roadAddress
				+ ", detailAddress=" + detailAddress + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate
				+ ", loginFailCount=" + loginFailCount + ", isLock=" + isLock + ", lastestTryLoginDate="
				+ lastestTryLoginDate + ", lockCount=" + lockCount + ", status=" + status + ", tempPwdYn=" + tempPwdYn
				+ ", memberRoleList=" + memberRoleList + "]";
	}
	
}
