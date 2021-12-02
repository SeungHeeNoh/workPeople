package com.kh.workPeople.jobs.companyInformation.model.vo;

import com.kh.workPeople.common.vo.CompanyInformation;

public class CompanyDetailInformation {

	private String companyName;
	private String address;
	private CompanyInformation companyInformation;
	private boolean liked;
	
	public CompanyDetailInformation() {}
	
	public CompanyDetailInformation(String companyName, String address, CompanyInformation companyInformation,
			boolean liked) {
		this.companyName = companyName;
		this.address = address;
		this.companyInformation = companyInformation;
		this.liked = liked;
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

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public CompanyInformation getCompanyInformation() {
		return companyInformation;
	}

	public void setCompanyInformation(CompanyInformation companyInformation) {
		this.companyInformation = companyInformation;
	}

	@Override
	public String toString() {
		return "CompanyDetailInformation [companyName=" + companyName + ", address=" + address + ", companyInformation="
				+ companyInformation + ", liked=" + liked + "]";
	}
	

}
