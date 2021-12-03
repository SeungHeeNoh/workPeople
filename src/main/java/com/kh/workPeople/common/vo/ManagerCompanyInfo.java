package com.kh.workPeople.common.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ManagerCompanyInfo {

	private int no;
	private String registerNumber;
	private String ceoName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date foundingDate;
	private int employeeNumber;
	private String businessDetail;
	private String companyHistory;
	private String companyVision;
	private String homepage;
	private Attachment attachment;
	private Sector sector;
	private CompanyType companyType;
	private Member member;
	private List<JobVacancy> list;
	private int count;
	
	public ManagerCompanyInfo() {}

	public ManagerCompanyInfo(int no, String registerNumber, String ceoName, Date foundingDate, int employeeNumber,
			String businessDetail, String companyHistory, String companyVision, String homepage, Attachment attachment,
			Sector sector, CompanyType companyType, Member member, List<JobVacancy> list, int count) {
		super();
		this.no = no;
		this.registerNumber = registerNumber;
		this.ceoName = ceoName;
		this.foundingDate = foundingDate;
		this.employeeNumber = employeeNumber;
		this.businessDetail = businessDetail;
		this.companyHistory = companyHistory;
		this.companyVision = companyVision;
		this.homepage = homepage;
		this.attachment = attachment;
		this.sector = sector;
		this.companyType = companyType;
		this.member = member;
		this.list = list;
		this.count = count;
	}





	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}



	
	public List<JobVacancy> getList() {
		return list;
	}





	public void setList(List<JobVacancy> list) {
		this.list = list;
	}





	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getRegisterNumber() {
		return registerNumber;
	}


	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}


	public String getCeoName() {
		return ceoName;
	}


	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}


	public Date getFoundingDate() {
		return foundingDate;
	}


	public void setFoundingDate(Date foundingDate) {
		this.foundingDate = foundingDate;
	}


	public int getEmployeeNumber() {
		return employeeNumber;
	}


	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}


	public String getBusinessDetail() {
		return businessDetail;
	}



	public void setBusinessDetail(String businessDetail) {
		this.businessDetail = businessDetail;
	}


	public String getCompanyHistory() {
		return companyHistory;
	}



	public void setCompanyHistory(String companyHistory) {
		this.companyHistory = companyHistory;
	}


	public String getCompanyVision() {
		return companyVision;
	}


	public void setCompanyVision(String companyVision) {
		this.companyVision = companyVision;
	}


	public String getHomepage() {
		return homepage;
	}


	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}


	public Attachment getAttachment() {
		return attachment;
	}


	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}


	public Sector getSector() {
		return sector;
	}


	public void setSector(Sector sector) {
		this.sector = sector;
	}


	public CompanyType getCompanyType() {
		return companyType;
	}


	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}
	

	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}


	@Override
	public String toString() {
		return "CompanyInformation [no=" + no + ", registerNumber=" + registerNumber + ", ceoName=" + ceoName
				+ ", foundingDate=" + foundingDate + ", employeeNumber=" + employeeNumber + ", businessDetail="
				+ businessDetail + ", companyHistory=" + companyHistory + ", companyVision=" + companyVision
				+ ", homepage=" + homepage + ", attachment=" + attachment + ", sector=" + sector + ", companyType="
				+ companyType + ", member=" + member + "]";
	}



	




}
