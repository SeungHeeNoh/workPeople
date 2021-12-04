package com.kh.workPeople.jobs.companyInformation.model.vo;

import java.util.List;

import com.kh.workPeople.common.vo.CompanyInformation;
import com.kh.workPeople.common.vo.JobVacancy;

public class CompanyDetailInformation {

	private String companyName;
	private String address;
	private int interestedCount;
	private String interestedCompany;
	private CompanyInformation companyInformation;
	private List<JobVacancy> progressingJobVacancyList;
	private List<JobVacancy> expiredJobVacancyList;
	
	public CompanyDetailInformation() {}

	public CompanyDetailInformation(String companyName, String address, int interestedCount, String interestedCompany, CompanyInformation companyInformation, List<JobVacancy> progressingJobVacancyList, List<JobVacancy> expiredJobVacancyList) {
		this.companyName = companyName;
		this.address = address;
		this.interestedCount = interestedCount;
		this.interestedCompany = interestedCompany;
		this.companyInformation = companyInformation;
		this.progressingJobVacancyList = progressingJobVacancyList;
		this.expiredJobVacancyList = expiredJobVacancyList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getInterestedCount() {
		return interestedCount;
	}

	public void setInterestedCount(int interestedCount) {
		this.interestedCount = interestedCount;
	}

	public String getInterestedCompany() {
		return interestedCompany;
	}

	public void setInterestedCompany(String interestedCompany) {
		this.interestedCompany = interestedCompany;
	}

	public CompanyInformation getCompanyInformation() {
		return companyInformation;
	}

	public void setCompanyInformation(CompanyInformation companyInformation) {
		this.companyInformation = companyInformation;
	}

	public List<JobVacancy> getProgressingJobVacancyList() {
		return progressingJobVacancyList;
	}

	public void setProgressingJobVacancyList(List<JobVacancy> progressingJobVacancyList) {
		this.progressingJobVacancyList = progressingJobVacancyList;
	}

	public List<JobVacancy> getExpiredJobVacancyList() {
		return expiredJobVacancyList;
	}

	public void setExpiredJobVacancyList(List<JobVacancy> expiredJobVacancyList) {
		this.expiredJobVacancyList = expiredJobVacancyList;
	}

	@Override
	public String toString() {
		return "CompanyDetailInformation [companyName=" + companyName + ", address=" + address + ", interestedCount="
				+ interestedCount + ", interestedCompany=" + interestedCompany + ", companyInformation="
				+ companyInformation + ", progressingJobVacancyList=" + progressingJobVacancyList
				+ ", expiredJobVacancyList=" + expiredJobVacancyList + "]";
	}
}
