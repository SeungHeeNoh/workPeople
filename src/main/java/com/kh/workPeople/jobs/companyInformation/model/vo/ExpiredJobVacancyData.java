package com.kh.workPeople.jobs.companyInformation.model.vo;

import java.util.List;

import com.kh.workPeople.common.vo.JobVacancy;
import com.kh.workPeople.common.vo.PageInfo;

public class ExpiredJobVacancyData {
	private PageInfo pageInfo;
	private List<JobVacancy> expiredJobVacancyList;
	
	public ExpiredJobVacancyData() {};

	public ExpiredJobVacancyData(PageInfo pageInfo, List<JobVacancy> expiredJobVacancyList) {
		this.pageInfo = pageInfo;
		this.expiredJobVacancyList = expiredJobVacancyList;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<JobVacancy> getExpiredJobVacancyList() {
		return expiredJobVacancyList;
	}

	public void setExpiredJobVacancyList(List<JobVacancy> expiredJobVacancyList) {
		this.expiredJobVacancyList = expiredJobVacancyList;
	}

	@Override
	public String toString() {
		return "ExpiredJobVacancyData [pageInfo=" + pageInfo + ", expiredJobVacancyList=" + expiredJobVacancyList + "]";
	}

}
