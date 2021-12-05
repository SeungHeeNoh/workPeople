package com.kh.workPeople.jobs.vacancyDetail.model.vo;

import java.util.Date;

import com.kh.workPeople.common.vo.JobVacancy;

public class JobVacancyInformation{

	private String companyName;
	private int companyNo;
	private String interestedCompany;
	private String scrapJobVacancy;
	private String reportedJobVacancy;
	private JobVacancy jobVacancy;
	private int dDay;

	public JobVacancyInformation() {}

	public JobVacancyInformation(String companyName, int companyNo, String interestedCompany, String scrapJobVacancy,
			String reportedJobVacancy, JobVacancy jobVacancy, int dDay) {
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.interestedCompany = interestedCompany;
		this.scrapJobVacancy = scrapJobVacancy;
		this.reportedJobVacancy = reportedJobVacancy;
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

	public JobVacancy getJobVacancy() {
		return jobVacancy;
	}

	public void setJobVacancy(JobVacancy jobVacancy) {
		this.jobVacancy = jobVacancy;
	}

	public int getdDay() {
		Date today = new Date();
		int dDay = (int)((jobVacancy.getPeriodEnd().getTime() - today.getTime())/(1000*60*60*24));
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}

	@Override
	public String toString() {
		return "JobVacancyInformation [companyName=" + companyName + ", companyNo=" + companyNo + ", interestedCompany="
				+ interestedCompany + ", scrapJobVacancy=" + scrapJobVacancy + ", reportedJobVacancy="
				+ reportedJobVacancy + ", jobVacancy=" + jobVacancy + ", dDay=" + dDay + "]";
	}

	
}
