package com.kh.workPeople.common.vo;

import java.util.Date;

public class ApplyCompany {

    private int jvNo;                   // 공고 번호
    private int rNo;                    // 이력서 번호
    private String acType;              // 지원 상태
    private Date acDate;                // 지원일
    private String acDeleteYN;          // 삭제 여부

    private String acDateFormat;        // 지원일 문자열 포멧(YYYY.MM.dd)

    public ApplyCompany() {
    }

    public ApplyCompany(int jvNo, int rNo, String acType, Date acDate, String acDeleteYN) {
        this.jvNo = jvNo;
        this.rNo = rNo;
        this.acType = acType;
        this.acDate = acDate;
        this.acDeleteYN = acDeleteYN;
    }

    public int getJvNo() {
        return jvNo;
    }

    public void setJvNo(int jvNo) {
        this.jvNo = jvNo;
    }

    public int getrNo() {
        return rNo;
    }

    public void setrNo(int rNo) {
        this.rNo = rNo;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public Date getAcDate() {
        return acDate;
    }

    public void setAcDate(Date acDate) {
        this.acDate = acDate;
    }

    public String getAcDeleteYN() {
        return acDeleteYN;
    }

    public void setAcDeleteYN(String acDeleteYN) {
        this.acDeleteYN = acDeleteYN;
    }

    public String getAcDateFormat() {
        return acDateFormat;
    }

    public void setAcDateFormat(String acDateFormat) {
        this.acDateFormat = acDateFormat;
    }

    @Override
    public String toString() {
        return "ApplyCompany{" +
                "jvNo=" + jvNo +
                ", rNo=" + rNo +
                ", acType='" + acType + '\'' +
                ", acDate=" + acDate +
                ", acDeleteYN='" + acDeleteYN + '\'' +
                '}';
    }
}
