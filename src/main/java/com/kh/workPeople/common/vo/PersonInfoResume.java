package com.kh.workPeople.common.vo;

import java.util.Date;

public class PersonInfoResume {
	/*
	 * R_NO NUMBER No 1 이력서번호 
	 * R_ENROLL_DATE DATE Yes "SYSDATE	" 2 등록일 
	 * M_NO NUMBER No 5 회원번호 
	 * S_NAME VARCHAR2(10 CHAR) No 2 업종명 
	 * BI_TITLE VARCHAR2(30 CHAR) No 2 이력서제목 
	 * BI_NAME VARCHAR2(10 CHAR) No 3 이름 
	 * BI_GENDER VARCHAR2(1 CHAR) No 4 성별
	 * BI_BIRTH_DATE DATE No 5 생년월일 
	 * BI_AGE NUMBER No 6 나이 
	 * BI_EMAIL VARCHAR2(90 CHAR) No 7 이메일 
	 * BI_ADDRESS VARCHAR2(30 CHAR) No 9 주소 
	 * BI_ADDRESS_DETAIL VARCHAR2(15 CHAR) No 10 상세주소
	 */
	
	private int rno;
	private Date enrollDate;
	private int mno;
	private String sname;
	private String title;
	private String name;
	private String gender;
	private Date dirthDate;
	private int age;
	private String email;
	private String address;
	private String addressDetail;
	private int cnt;
	
	
	public PersonInfoResume() {}


	public PersonInfoResume(int rno, Date enrollDate, int mno, String sname, String title, String name, String gender,
			Date dirthDate, int age, String email, String address, String addressDetail, int cnt) {
		super();
		this.rno = rno;
		this.enrollDate = enrollDate;
		this.mno = mno;
		this.sname = sname;
		this.title = title;
		this.name = name;
		this.gender = gender;
		this.dirthDate = dirthDate;
		this.age = age;
		this.email = email;
		this.address = address;
		this.addressDetail = addressDetail;
		this.cnt = cnt;
	}


	public int getRno() {
		return rno;
	}


	public void setRno(int rno) {
		this.rno = rno;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDirthDate() {
		return dirthDate;
	}


	public void setDirthDate(Date dirthDate) {
		this.dirthDate = dirthDate;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddressDetail() {
		return addressDetail;
	}


	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	@Override
	public String toString() {
		return "PersonInfoResume [rno=" + rno + ", enrollDate=" + enrollDate + ", mno=" + mno + ", sname=" + sname
				+ ", title=" + title + ", name=" + name + ", gender=" + gender + ", dirthDate=" + dirthDate + ", age="
				+ age + ", email=" + email + ", address=" + address + ", addressDetail=" + addressDetail + ", cnt="
				+ cnt + "]";
	}


	

}
