package com.kh.workPeople.common.vo;

import java.util.Date;

public class JobVacancyLookUpSimple {
    private int no;             // 기업번호
    private String name;        // 기업이름
    private int count;          // 채용중인 공고 갯수

    private String type;        // 지원 상태
    private Date aiDate;        // 면접일
    private Date aiTime;        // 면접 시간

    private String aiStatusYN;  // 면접 종료 여부(Y,N)
    private int aiStatusYNFormat;   // 면접 종료 여부 숫자 변환(0,1)

    private String aiDateFormat;    // 면접일 문자열
    private String aiTimeFormat;    // 면접 시간 문자열
    
    public JobVacancyLookUpSimple() {

    }

   


	public JobVacancyLookUpSimple(int no, String name, int count, String type, Date aiDate, Date aiTime,
			String aiDateFormat, String aiTimeFormat) {
		super();
		this.no = no;
		this.name = name;
		this.count = count;
		this.type = type;
		this.aiDate = aiDate;
		this.aiTime = aiTime;
		this.aiDateFormat = aiDateFormat;
		this.aiTimeFormat = aiTimeFormat;
	}

    public JobVacancyLookUpSimple(int no, String name, int count, String type, Date aiDate, Date aiTime, String aiStatusYN, int aiStatusYNFormat, String aiDateFormat, String aiTimeFormat) {
        this.no = no;
        this.name = name;
        this.count = count;
        this.type = type;
        this.aiDate = aiDate;
        this.aiTime = aiTime;
        this.aiStatusYN = aiStatusYN;
        this.aiStatusYNFormat = aiStatusYNFormat;
        this.aiDateFormat = aiDateFormat;
        this.aiTimeFormat = aiTimeFormat;
    }

    public String getAiStatusYN() {
        return aiStatusYN;
    }

    public void setAiStatusYN(String aiStatusYN) {
        this.aiStatusYN = aiStatusYN;
    }

    public int getAiStatusYNFormat() {
        return aiStatusYNFormat;
    }

    public void setAiStatusYNFormat(int aiStatusYNFormat) {
        this.aiStatusYNFormat = aiStatusYNFormat;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAiDate() {
        return aiDate;
    }

    public void setAiDate(Date aiDate) {
        this.aiDate = aiDate;
    }

    public Date getAiTime() {
        return aiTime;
    }

    public void setAiTime(Date aiTime) {
        this.aiTime = aiTime;
    }

    public String getAiDateFormat() {
        return aiDateFormat;
    }

    public void setAiDateFormat(String aiDateFormat) {
        this.aiDateFormat = aiDateFormat;
    }

    public String getAiTimeFormat() {
        return aiTimeFormat;
    }

    public void setAiTimeFormat(String aiTimeFormat) {
        this.aiTimeFormat = aiTimeFormat;
    }

	@Override
	public String toString() {
		return "JobVacancyLookUpSimple [no=" + no + ", name=" + name + ", count=" + count + ", type=" + type
				+ ", aiDate=" + aiDate + ", aiTime=" + aiTime + ", aiDateFormat=" + aiDateFormat + ", aiTimeFormat="
				+ aiTimeFormat + "]";
	}
    

	
}
