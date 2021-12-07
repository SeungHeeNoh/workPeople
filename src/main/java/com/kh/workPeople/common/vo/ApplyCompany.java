package com.kh.workPeople.common.vo;

import java.util.Date;

public class ApplyCompany {

    private int acNo;                   // 입사지원 구분번호
    private int jvNo;                   // 공고 번호
    private int mNo;                    // 회원 번호
    private String acType;              // 지원상태
    private Date acDate;                // 지원일
    private String acDeleteYN;          // 삭제 여부

    private String acDateFormat;        // 지원일 문자열 포멧(YYYY.MM.dd)

    public ApplyCompany() {
    }

    public ApplyCompany(int acNo, int jvNo, int mNo, String acType, Date acDate, String acDeleteYN, String acDateFormat) {
        this.acNo = acNo;
        this.jvNo = jvNo;
        this.mNo = mNo;
        this.acType = acType;
        this.acDate = acDate;
        this.acDeleteYN = acDeleteYN;
        this.acDateFormat = acDateFormat;
    }

    public int getJvNo() {
        return jvNo;
    }

    public void setJvNo(int jvNo) {
        this.jvNo = jvNo;
    }

    public int getmNo() {
        return mNo;
    }

    public void setmNo(int mNo) {
        this.mNo = mNo;
    }

    public int getAcNo() {
        return acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
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
                ", mNo=" + mNo +
                ", acNo=" + acNo +
                ", acType='" + acType + '\'' +
                ", acDate=" + acDate +
                ", acDeleteYN='" + acDeleteYN + '\'' +
                ", acDateFormat='" + acDateFormat + '\'' +
                '}';
    }
}
