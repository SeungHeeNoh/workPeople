package com.kh.workPeople.jobs.companyInformation.model.vo;

import com.kh.workPeople.common.vo.JobVacancy;

public class JobVacancyData {

	private int no;
	private JobVacancy jobVacancy;
	private String applied;
	
	public JobVacancyData() {}

	public JobVacancyData(int no, JobVacancy jobVacancy, String applied) {
		this.no = no;
		this.jobVacancy = jobVacancy;
		this.applied = applied;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public JobVacancy getJobVacancy() {
		return jobVacancy;
	}

	public void setJobVacancy(JobVacancy jobVacancy) {
		this.jobVacancy = jobVacancy;
	}

	public String getApplied() {
		return applied;
	}

	public void setApplied(String applied) {
		this.applied = applied;
	}

	@Override
	public String toString() {
		return "JobVacancyData [no=" + no + ", jobVacancy=" + jobVacancy + ", applied=" + applied + "]";
	}

}
