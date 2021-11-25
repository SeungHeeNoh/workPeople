package com.kh.workPeople.common.vo;

import java.util.Date;

public class JobVacancyLookUpSimple {
    private int no;             // 기업번호
    private String name;        // 기업이름
    private int count;          // 채용중인 공고 갯수
    private String Type;        // 지원 상태
    private Date aiDate;        // 면접일
    private Date aiTime;        // 면접 시간

    private String aiDateFormat;    // 면접일 문자열
    private String aiTimeFormat;    // 면접 시간 문자열

    public JobVacancyLookUpSimple() {

    }

    public JobVacancyLookUpSimple(int no, String name, int count, String type, Date aiDate, Date aiTime) {
        this.no = no;
        this.name = name;
        this.count = count;
        Type = type;
        this.aiDate = aiDate;
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
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

    @Override
    public String toString() {
        return "JobVacancyLookUpSimple{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
