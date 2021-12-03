package com.kh.workPeople.common.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public class JobVacancy {

	private int no;
	private String title;
	private Date register;
	private Date update;
	private Date display;
	private int count;
	private int to;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date peiodStart;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date periodEnd;
	private String workdayStartTime;
	private String workdayEndTime;
	private String address;
	private Gender gender;
	private EducationLevel educationLevel;
	private String major;
	private Day day;
	private String status;
	private String detailText;
	private String certificate;
	private String age;
	private String pay;
	private PayType payType;
	private List<Role> roleList;
	private List<JobType> jobTypeList;
	private List<ExperienceLevel> experienceLevelList;
	private List<Sector> sectorList;
	
	public JobVacancy() {}

	public JobVacancy(int no, String title, Date register, Date update, Date display, int count, int to,
			Date peiodStart, Date periodEnd, String workdayStartTime, String workdayEndTime, String address,
			Gender gender, EducationLevel educationLevel, String major, Day day, String status, String detailText,
			String certificate, String age, String pay, PayType payType, List<Role> roleList, List<JobType> jobTypeList,
			List<ExperienceLevel> experienceLevelList, List<Sector> sectorList) {
		this.no = no;
		this.title = title;
		this.register = register;
		this.update = update;
		this.display = display;
		this.count = count;
		this.to = to;
		this.peiodStart = peiodStart;
		this.periodEnd = periodEnd;
		this.workdayStartTime = workdayStartTime;
		this.workdayEndTime = workdayEndTime;
		this.address = address;
		this.gender = gender;
		this.educationLevel = educationLevel;
		this.major = major;
		this.day = day;
		this.status = status;
		this.detailText = detailText;
		this.certificate = certificate;
		this.age = age;
		this.pay = pay;
		this.payType = payType;
		this.roleList = roleList;
		this.jobTypeList = jobTypeList;
		this.experienceLevelList = experienceLevelList;
		this.sectorList = sectorList;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegister() {
		return register;
	}

	public void setRegister(Date register) {
		this.register = register;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public Date getDisplay() {
		return display;
	}

	public void setDisplay(Date display) {
		this.display = display;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public Date getPeiodStart() {
		return peiodStart;
	}

	public void setPeiodStart(Date peiodStart) {
		this.peiodStart = peiodStart;
	}

	public Date getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}

	public String getWorkdayStartTime() {
		return workdayStartTime;
	}

	public void setWorkdayStartTime(String workdayStartTime) {
		this.workdayStartTime = workdayStartTime;
	}

	public String getWorkdayEndTime() {
		return workdayEndTime;
	}

	public void setWorkdayEndTime(String workdayEndTime) {
		this.workdayEndTime = workdayEndTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetailText() {
		return detailText;
	}

	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<JobType> getJobTypeList() {
		return jobTypeList;
	}

	public void setJobTypeList(List<JobType> jobTypeList) {
		this.jobTypeList = jobTypeList;
	}

	public List<ExperienceLevel> getExperienceLevelList() {
		return experienceLevelList;
	}

	public void setExperienceLevelList(List<ExperienceLevel> experienceLevelList) {
		this.experienceLevelList = experienceLevelList;
	}

	public List<Sector> getSectorList() {
		return sectorList;
	}

	public void setSectorList(List<Sector> sectorList) {
		this.sectorList = sectorList;
	}

	@Override
	public String toString() {
		return "JobVacancy [no=" + no + ", title=" + title + ", register=" + register + ", update=" + update
				+ ", display=" + display + ", count=" + count + ", to=" + to + ", peiodStart=" + peiodStart
				+ ", periodEnd=" + periodEnd + ", workdayStartTime=" + workdayStartTime + ", workdayEndTime="
				+ workdayEndTime + ", address=" + address + ", gender=" + gender + ", educationLevel=" + educationLevel
				+ ", major=" + major + ", day=" + day + ", status=" + status + ", detailText=" + detailText
				+ ", certificate=" + certificate + ", age=" + age + ", pay=" + pay + ", payType=" + payType
				+ ", roleList=" + roleList + ", jobTypeList=" + jobTypeList + ", experienceLevelList="
				+ experienceLevelList + ", sectorList=" + sectorList + "]";
	}
	
	
	
}
