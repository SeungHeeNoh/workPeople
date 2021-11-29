package com.kh.workPeople.common.vo;

import java.util.Date;

public class Language {

    private int lNo;                        // 어학 번호
    private int rNo;                        // 이력서 번호
    private String lName;                   // 언어 종류
    private String lType;                   // 시험 종류
    private int lScore;                     // 점수
    private String lRating;                 // 급수
    private Date lAcquisition;              // 취득일

    private String lAcquisitionFormat;      // 취득일 문자열 포멧팅(YYYY.MM)

    public Language() {
    }

    public Language(int lNo, int rNo, String lName, String lType, int lScore, String lRating, Date lAcquisition) {
        this.lNo = lNo;
        this.rNo = rNo;
        this.lName = lName;
        this.lType = lType;
        this.lScore = lScore;
        this.lRating = lRating;
        this.lAcquisition = lAcquisition;
    }

    public Language(int lNo, int rNo, String lName, String lType, int lScore, String lRating, Date lAcquisition, String lAcquisitionFormat) {
        this.lNo = lNo;
        this.rNo = rNo;
        this.lName = lName;
        this.lType = lType;
        this.lScore = lScore;
        this.lRating = lRating;
        this.lAcquisition = lAcquisition;
        this.lAcquisitionFormat = lAcquisitionFormat;
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

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType;
    }

    public int getlScore() {
        return lScore;
    }

    public void setlScore(int lScore) {
        this.lScore = lScore;
    }

    public String getlRating() {
        return lRating;
    }

    public void setlRating(String lRating) {
        this.lRating = lRating;
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
                ", lType='" + lType + '\'' +
                ", lScore=" + lScore +
                ", lRating='" + lRating + '\'' +
                ", lAcquisition=" + lAcquisition +
                '}';
    }
}
