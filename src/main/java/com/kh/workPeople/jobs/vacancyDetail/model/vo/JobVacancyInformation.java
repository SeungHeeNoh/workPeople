package com.kh.workPeople.jobs.vacancyDetail.model.vo;

import com.kh.workPeople.common.vo.JobVacancy;

public class JobVacancyInformation{

	private String companyName;
	private int companyNo;
	private String interestedCompany;
	private String scrapJobVacancy;
	private JobVacancy jobVacancy;

	public JobVacancyInformation() {}

	public JobVacancyInformation(String companyName, int companyNo, String interestedCompany, String scrapJobVacancy,
			JobVacancy jobVacancy) {
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.interestedCompany = interestedCompany;
		this.scrapJobVacancy = scrapJobVacancy;
		this.jobVacancy = jobVacancy;
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

	public JobVacancy getJobVacancy() {
		return jobVacancy;
	}

	public void setJobVacancy(JobVacancy jobVacancy) {
		this.jobVacancy = jobVacancy;
	}

	@Override
	public String toString() {
		return "JobVacancyInformation [companyName=" + companyName + ", companyNo=" + companyNo + ", interestedCompany="
				+ interestedCompany + ", scrapJobVacancy=" + scrapJobVacancy + ", jobVacancy=" + jobVacancy + "]";
	}
	
}
