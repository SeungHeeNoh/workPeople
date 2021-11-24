package com.kh.workPeople.common.vo;

import java.util.Date;

public class JobVacancyLookUp {
    private int jvNo;               // 공고번호
    private String mName;           // 회사이름
    private String jvTitle;           // 공고 제목
    private String elName;          // 경력명
    private String sName;           // 업종명
    private String jvAddress;     // 근무지역 주소
    private Date acDate;            // 지원일
    private Date rbDate;            // 열람일
    private Date jvPeriodEnd;       // 마감일

    private String acDateFormat;    // 지원일 문자열형태
    private String rbDateFormat;    // 열람일 문자열형태
    private String jvPeriodEndFormat;   // 마감일 문자열형태
    
    public JobVacancyLookUp() {
    }

    public JobVacancyLookUp(int jvNo, String mName, String jvTitle, String elName, String sName, String jvAddress, Date acDate, Date rbDate, Date jvPeriodEnd) {
        this.jvNo = jvNo;
        this.mName = mName;
        this.jvTitle = jvTitle;
        this.elName = elName;
        this.sName = sName;
        this.jvAddress = jvAddress;
        this.acDate = acDate;
        this.rbDate = rbDate;
        this.jvPeriodEnd = jvPeriodEnd;
    }

    public Date getJvPeriodEnd() {
        return jvPeriodEnd;
    }

    public void setJvPeriodEnd(Date jvPeriodEnd) {
        this.jvPeriodEnd = jvPeriodEnd;
    }

    public String getJvPeriodEndFormat() {
        return jvPeriodEndFormat;
    }

    public void setJvPeriodEndFormat(String jvPeriodEndFormat) {
        this.jvPeriodEndFormat = jvPeriodEndFormat;
    }

    public int getJvNo() {
        return jvNo;
    }

    public void setJvNo(int jvNo) {
        this.jvNo = jvNo;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getJvTitle() {
        return jvTitle;
    }

    public void setJvTitle(String jvTitle) {
        this.jvTitle = jvTitle;
    }

    public String getElName() {
        return elName;
    }

    public void setElName(String elName) {
        this.elName = elName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getJvAddress() {
        return jvAddress;
    }

    public void setJvAddress(String jvAddress) {
        this.jvAddress = jvAddress;
    }

    public Date getAcDate() {
        return acDate;
    }

    public void setAcDate(Date acDate) {
        this.acDate = acDate;
    }

    public Date getRbDate() {
        return rbDate;
    }

    public void setRbDate(Date rbDate) {
        this.rbDate = rbDate;
    }

    public String getAcDateFormat() {
        return acDateFormat;
    }

    public void setAcDateFormat(String acDateFormat) {
        this.acDateFormat = acDateFormat;
    }

    public String getRbDateFormat() {
        return rbDateFormat;
    }

    public void setRbDateFormat(String rbDateFormat) {
        this.rbDateFormat = rbDateFormat;
    }

    @Override
    public String toString() {
        return "JobVacancyLookUp{" +
                "jvNo=" + jvNo +
                ", mName='" + mName + '\'' +
                ", jvTitle='" + jvTitle + '\'' +
                ", elName='" + elName + '\'' +
                ", sName='" + sName + '\'' +
                ", roadAddress='" + jvAddress + '\'' +
                ", acDate=" + acDate +
                ", rbDate=" + rbDate +
                ", acDateFormat='" + acDateFormat + '\'' +
                ", rbDateFormat='" + rbDateFormat + '\'' +
                '}';
    }
}
