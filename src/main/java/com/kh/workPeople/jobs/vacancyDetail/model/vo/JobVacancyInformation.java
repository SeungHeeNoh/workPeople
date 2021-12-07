package com.kh.workPeople.jobs.vacancyDetail.model.vo;

import java.util.Date;

import com.kh.workPeople.common.vo.JobVacancy;

public class JobVacancyInformation{

	private String companyName;
	private int companyNo;
	private String interestedCompany;
	private String scrapJobVacancy;
	private String reportedJobVacancy;
	private String appliedJobVacancy;
	private int appliedTotalCount;
	private int appliedManCount;
	private JobVacancy jobVacancy;
	private int dDay;

	public JobVacancyInformation() {}

	public JobVacancyInformation(String companyName, int companyNo, String interestedCompany, String scrapJobVacancy,
			String reportedJobVacancy, String appliedJobVacancy, int appliedTotalCount, int appliedManCount,
			JobVacancy jobVacancy, int dDay) {
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.interestedCompany = interestedCompany;
		this.scrapJobVacancy = scrapJobVacancy;
		this.reportedJobVacancy = reportedJobVacancy;
		this.appliedJobVacancy = appliedJobVacancy;
		this.appliedTotalCount = appliedTotalCount;
		this.appliedManCount = appliedManCount;
		this.jobVacancy = jobVacancy;
		this.dDay = dDay;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getInterestedCompany() {
		return interestedCompany;
	}

	public void setInterestedCompany(String interestedCompany) {
		this.interestedCompany = interestedCompany;
	}

	public String getScrapJobVacancy() {
		return scrapJobVacancy;
	}

	public void setScrapJobVacancy(String scrapJobVacancy) {
		this.scrapJobVacancy = scrapJobVacancy;
	}

	public String getReportedJobVacancy() {
		return reportedJobVacancy;
	}

	public void setReportedJobVacancy(String reportedJobVacancy) {
		this.reportedJobVacancy = reportedJobVacancy;
	}

	public String getAppliedJobVacancy() {
		return appliedJobVacancy;
	}

	public void setAppliedJobVacancy(String appliedJobVacancy) {
		this.appliedJobVacancy = appliedJobVacancy;
	}

	public int getAppliedTotalCount() {
		return appliedTotalCount;
	}

	public void setAppliedTotalCount(int appliedTotalCount) {
		this.appliedTotalCount = appliedTotalCount;
	}

	public int getAppliedManCount() {
		return appliedManCount;
	}

	public void setAppliedManCount(int appliedManCount) {
		this.appliedManCount = appliedManCount;
	}

	public JobVacancy getJobVacancy() {
		return jobVacancy;
	}

	public void setJobVacancy(JobVacancy jobVacancy) {
		this.jobVacancy = jobVacancy;
	}

	public int getdDay() {
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}

	@Override
	public String toString() {
		return "JobVacancyInformation [companyName=" + companyName + ", companyNo=" + companyNo + ", interestedCompany="
				+ interestedCompany + ", scrapJobVacancy=" + scrapJobVacancy + ", reportedJobVacancy="
				+ reportedJobVacancy + ", appliedJobVacancy=" + appliedJobVacancy + ", appliedTotalCount="
				+ appliedTotalCount + ", appliedManCount=" + appliedManCount + ", jobVacancy=" + jobVacancy + ", dDay="
				+ dDay + "]";
	}

}
