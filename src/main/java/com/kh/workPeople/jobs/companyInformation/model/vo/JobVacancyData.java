package com.kh.workPeople.jobs.companyInformation.model.vo;

import java.util.List;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.PageInfo;

public class JobVacancyData {
	private PageInfo pageInfo;
	private List<JobVacancy> jobVacancyList;
	
	public JobVacancyData() {}
	
	public JobVacancyData(PageInfo pageInfo, List<JobVacancy> jobVacancyList) {
		this.pageInfo = pageInfo;
		this.jobVacancyList = jobVacancyList;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<JobVacancy> getJobVacancyList() {
		return jobVacancyList;
	}

	public void setJobVacancyList(List<JobVacancy> jobVacancyList) {
		this.jobVacancyList = jobVacancyList;
	}

	@Override
	public String toString() {
		return "JobVacancyData [pageInfo=" + pageInfo + ", jobVacancyList=" + jobVacancyList + "]";
	}
	
}
