package com.kh.workPeople.jobs.companyInformation.model.vo;

import java.util.List;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.PageInfo;

public class JobVacancyAndPageInfo {
	private PageInfo pageInfo;
	private List<JobVacancyData> jobVacancyDataList;
	
	public JobVacancyAndPageInfo() {}

	public JobVacancyAndPageInfo(PageInfo pageInfo, List<JobVacancyData> jobVacancyDataList) {
		this.pageInfo = pageInfo;
		this.jobVacancyDataList = jobVacancyDataList;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<JobVacancyData> getJobVacancyDataList() {
		return jobVacancyDataList;
	}

	public void setJobVacancyDataList(List<JobVacancyData> jobVacancyDataList) {
		this.jobVacancyDataList = jobVacancyDataList;
	}

	@Override
	public String toString() {
		return "JobVacancyAndPageInfo [pageInfo=" + pageInfo + ", jobVacancyDataList=" + jobVacancyDataList + "]";
	}
	
}
