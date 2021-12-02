package com.kh.workPeople.jobs.companyInformation.model.vo;

import com.kh.workPeople.common.vo.CompanyInformation;

public class CompanyDetailInformation {

	private String companyName;
	private String address;
	private int interestedCount;
	private String interestedCompany;
	private CompanyInformation companyInformation;
	
	public CompanyDetailInformation() {}

	public CompanyDetailInformation(String companyName, String address, int interestedCount, String interestedCompany,
			CompanyInformation companyInformation) {
		this.companyName = companyName;
		this.address = address;
		this.interestedCount = interestedCount;
		this.interestedCompany = interestedCompany;
		this.companyInformation = companyInformation;
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

	@Override
	public String toString() {
		return "CompanyDetailInformation [companyName=" + companyName + ", address=" + address + ", interestedCount="
				+ interestedCount + ", interestedCompany=" + interestedCompany + ", companyInformation="
				+ companyInformation + "]";
	}
	
}
