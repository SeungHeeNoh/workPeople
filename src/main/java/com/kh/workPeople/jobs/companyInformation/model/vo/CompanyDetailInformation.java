package com.kh.workPeople.jobs.companyInformation.model.vo;

import com.kh.workPeople.common.vo.CompanyInformation;

public class CompanyDetailInformation {

	private String companyName;
	private String address;
	private int interestedCount;
	private String interestedCompany;
	private CompanyInformation companyInformation;
	private ProgressingJobVacancyData progressingJobVacancyData;
	private ExpiredJobVacancyData expiredJobVacancyData;
	
	public CompanyDetailInformation() {}

	public CompanyDetailInformation(String companyName, String address, int interestedCount, String interestedCompany,
			CompanyInformation companyInformation, ProgressingJobVacancyData progressingJobVacancyData,
			ExpiredJobVacancyData expiredJobVacancyData) {
		this.companyName = companyName;
		this.address = address;
		this.interestedCount = interestedCount;
		this.interestedCompany = interestedCompany;
		this.companyInformation = companyInformation;
		this.progressingJobVacancyData = progressingJobVacancyData;
		this.expiredJobVacancyData = expiredJobVacancyData;
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

	public ProgressingJobVacancyData getProgressingJobVacancyData() {
		return progressingJobVacancyData;
	}

	public void setProgressingJobVacancyData(ProgressingJobVacancyData progressingJobVacancyData) {
		this.progressingJobVacancyData = progressingJobVacancyData;
	}

	public ExpiredJobVacancyData getExpiredJobVacancyData() {
		return expiredJobVacancyData;
	}

	public void setExpiredJobVacancyData(ExpiredJobVacancyData expiredJobVacancyData) {
		this.expiredJobVacancyData = expiredJobVacancyData;
	}

	@Override
	public String toString() {
		return "CompanyDetailInformation [companyName=" + companyName + ", address=" + address + ", interestedCount="
				+ interestedCount + ", interestedCompany=" + interestedCompany + ", companyInformation="
				+ companyInformation + ", progressingJobVacancyData=" + progressingJobVacancyData
				+ ", expiredJobVacancyData=" + expiredJobVacancyData + "]";
	}

}
