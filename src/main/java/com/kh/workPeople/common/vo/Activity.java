package com.kh.workPeople.common.vo;

import java.util.Date;

public class Activity {

    private int acNo;                   // 입사지원 구분 번호
    private int aNo;                    // 활동번호
    private int rNo;                    // 이력서번호
    private String aActivity;           // 활동 구분
    private String aDepartment;         // 기관,장소
    private String a_content;           // 활동 내용
    private Date aStartDate;            // 활동 시작일
    private Date aEndDate;              // 활동 종료일

    private String aStartDateFormat;    // 활동 시작일 포멧팅(YYYY.MM)
    private String aEndDateFormat;      // 활동 종료일 포멧팅(YYYY.MM)


    public Activity() {
    }

    public Activity(int aNo, int rNo, String aActivity, String aDepartment, String a_content, Date aStartDate, Date aEndDate) {
        this.aNo = aNo;
        this.rNo = rNo;
        this.aActivity = aActivity;
        this.aDepartment = aDepartment;
        this.a_content = a_content;
        this.aStartDate = aStartDate;
        this.aEndDate = aEndDate;
    }

    public Activity(int aNo, int rNo, String aActivity, String aDepartment, String a_content, Date aStartDate, Date aEndDate, String aStartDateFormat, String aEndDateFormat) {
        this.aNo = aNo;
        this.rNo = rNo;
        this.aActivity = aActivity;
        this.aDepartment = aDepartment;
        this.a_content = a_content;
        this.aStartDate = aStartDate;
        this.aEndDate = aEndDate;
        this.aStartDateFormat = aStartDateFormat;
        this.aEndDateFormat = aEndDateFormat;
    }

    public Activity(int acNo, int aNo, int rNo, String aActivity, String aDepartment, String a_content, Date aStartDate, Date aEndDate, String aStartDateFormat, String aEndDateFormat) {
        this.acNo = acNo;
        this.aNo = aNo;
        this.rNo = rNo;
        this.aActivity = aActivity;
        this.aDepartment = aDepartment;
        this.a_content = a_content;
        this.aStartDate = aStartDate;
        this.aEndDate = aEndDate;
        this.aStartDateFormat = aStartDateFormat;
        this.aEndDateFormat = aEndDateFormat;
    }

    public int getAcNo() {
        return acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public int getaNo() {
        return aNo;
    }

    public void setaNo(int aNo) {
        this.aNo = aNo;
    }

    public int getrNo() {
        return rNo;
    }

    public void setrNo(int rNo) {
        this.rNo = rNo;
    }

    public String getaActivity() {
        return aActivity;
    }

    public void setaActivity(String aActivity) {
        this.aActivity = aActivity;
    }

    public String getaDepartment() {
        return aDepartment;
    }

    public void setaDepartment(String aDepartment) {
        this.aDepartment = aDepartment;
    }

    public String getA_content() {
        return a_content;
    }

    public void setA_content(String a_content) {
        this.a_content = a_content;
    }

    public Date getaStartDate() {
        return aStartDate;
    }

    public void setaStartDate(Date aStartDate) {
        this.aStartDate = aStartDate;
    }

    public Date getaEndDate() {
        return aEndDate;
    }

    public void setaEndDate(Date aEndDate) {
        this.aEndDate = aEndDate;
    }

    public String getaStartDateFormat() {
        return aStartDateFormat;
    }

    public void setaStartDateFormat(String aStartDateFormat) {
        this.aStartDateFormat = aStartDateFormat;
    }

    public String getaEndDateFormat() {
        return aEndDateFormat;
    }

    public void setaEndDateFormat(String aEndDateFormat) {
        this.aEndDateFormat = aEndDateFormat;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "aNo=" + aNo +
                ", rNo=" + rNo +
                ", aActivity='" + aActivity + '\'' +
                ", aDepartment='" + aDepartment + '\'' +
                ", a_content='" + a_content + '\'' +
                ", aStartDate=" + aStartDate +
                ", aEndDate=" + aEndDate +
                '}';
    }
}
