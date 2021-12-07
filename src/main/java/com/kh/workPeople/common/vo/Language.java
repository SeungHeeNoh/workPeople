package com.kh.workPeople.common.vo;

import java.util.Date;

public class Language {

    private int acNo;                   // 입사지원 구분 번호
    private int lNo;                        // 어학 번호
    private int rNo;                        // 이력서 번호
    private String lName;                   // 언어/시험명
    private String lDepartment;             // 발행처
    private String lScore;                     // 급수/점수
    private Date lAcquisition;              // 취득일

    private String lAcquisitionFormat;      // 취득일 문자열 포멧팅(YYYY.MM)

    public Language() {
    }

    public Language(int lNo, int rNo, String lName, String lDepartment, String lScore, Date lAcquisition, String lAcquisitionFormat) {
        this.lNo = lNo;
        this.rNo = rNo;
        this.lName = lName;
        this.lDepartment = lDepartment;
        this.lScore = lScore;
        this.lAcquisition = lAcquisition;
        this.lAcquisitionFormat = lAcquisitionFormat;
    }

    public Language(int acNo, int lNo, int rNo, String lName, String lDepartment, String lScore, Date lAcquisition, String lAcquisitionFormat) {
        this.acNo = acNo;
        this.lNo = lNo;
        this.rNo = rNo;
        this.lName = lName;
        this.lDepartment = lDepartment;
        this.lScore = lScore;
        this.lAcquisition = lAcquisition;
        this.lAcquisitionFormat = lAcquisitionFormat;
    }

    public int getAcNo() {
        return acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public int getlNo() {
        return lNo;
    }

    public void setlNo(int lNo) {
        this.lNo = lNo;
    }

    public int getrNo() {
        return rNo;
    }

    public void setrNo(int rNo) {
        this.rNo = rNo;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlDepartment() {
        return lDepartment;
    }

    public void setlDepartment(String lDepartment) {
        this.lDepartment = lDepartment;
    }

    public String getlScore() {
        return lScore;
    }

    public void setlScore(String lScore) {
        this.lScore = lScore;
    }

    public Date getlAcquisition() {
        return lAcquisition;
    }

    public void setlAcquisition(Date lAcquisition) {
        this.lAcquisition = lAcquisition;
    }

    public String getlAcquisitionFormat() {
        return lAcquisitionFormat;
    }

    public void setlAcquisitionFormat(String lAcquisitionFormat) {
        this.lAcquisitionFormat = lAcquisitionFormat;
    }

    @Override
    public String toString() {
        return "Language{" +
                "lNo=" + lNo +
                ", rNo=" + rNo +
                ", lName='" + lName + '\'' +
                ", lDepartment='" + lDepartment + '\'' +
                ", lScore=" + lScore +
                ", lAcquisition=" + lAcquisition +
                ", lAcquisitionFormat='" + lAcquisitionFormat + '\'' +
                '}';
    }
}
