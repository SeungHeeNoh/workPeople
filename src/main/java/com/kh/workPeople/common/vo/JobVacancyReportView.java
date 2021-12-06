package com.kh.workPeople.common.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public class JobVacancyReportView {

	private int no; //공고 번호
	private String title; //공고 제목
	private Date register; //공고 등록일
	private int count; //공고 조회수
	private String companyName;
	private int reportCount;
	
	public JobVacancyReportView() {}

	
	
	public JobVacancyReportView(int no, String title, Date register, int count, String companyName, int reportCount) {
		super();
		this.no = no;
		this.title = title;
		this.register = register;
		this.count = count;
		this.companyName = companyName;
		this.reportCount = reportCount;
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Date getRegister() {
		return register;
	}



	public void setRegister(Date register) {
		this.register = register;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public int getReportCount() {
		return reportCount;
	}



	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}



	@Override
	public String toString() {
		return "JobVacancyReportView [no=" + no + ", title=" + title + ", register=" + register + ", count=" + count
				+ ", companyName=" + companyName + ", reportCount=" + reportCount + "]";
	}
	
	
	
	

	
	
	
}
