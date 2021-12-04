package com.kh.workPeople.jobs.companyInformation.model.vo;

import java.util.List;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.PageInfo;

public class ProgressingJobVacancyData {
	private PageInfo pageInfo;
	private List<JobVacancy> progressingJobVacancyList;
	
	public ProgressingJobVacancyData() {}

	public ProgressingJobVacancyData(PageInfo pageInfo, List<JobVacancy> progressingJobVacancyList) {
		this.pageInfo = pageInfo;
		this.progressingJobVacancyList = progressingJobVacancyList;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<JobVacancy> getProgressingJobVacancyList() {
		return progressingJobVacancyList;
	}

	public void setProgressingJobVacancyList(List<JobVacancy> progressingJobVacancyList) {
		this.progressingJobVacancyList = progressingJobVacancyList;
	}

	@Override
	public String toString() {
		return "ProgressingJobVacancyData [pageInfo=" + pageInfo + ", progressingJobVacancyList="
				+ progressingJobVacancyList + "]";
	}
}
