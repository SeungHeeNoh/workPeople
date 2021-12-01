package com.kh.workPeople.common.vo;

import java.util.Date;

public class Awards {

    private int aNo;                        // 수상내역 번호
    private int rNo;                        // 이력서 번호
    private String aName;                   // 수상명
    private String aDepartment;             // 수여기관
    private Date aAcquisition;              // 취득일

    private String aAcquisitionFormat;      // 취득일 문자열 포멧팅(YYYY.MM)

    public Awards() {
    }

    public Awards(int aNo, int rNo, String aName, String aDepartment, Date aAcquisition, String aAcquisitionFormat) {
        this.aNo = aNo;
        this.rNo = rNo;
        this.aName = aName;
        this.aDepartment = aDepartment;
        this.aAcquisition = aAcquisition;
        this.aAcquisitionFormat = aAcquisitionFormat;
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

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaDepartment() {
        return aDepartment;
    }

    public void setaDepartment(String aDepartment) {
        this.aDepartment = aDepartment;
    }

    public Date getaAcquisition() {
        return aAcquisition;
    }

    public void setaAcquisition(Date aAcquisition) {
        this.aAcquisition = aAcquisition;
    }

    public String getaAcquisitionFormat() {
        return aAcquisitionFormat;
    }

    public void setaAcquisitionFormat(String aAcquisitionFormat) {
        this.aAcquisitionFormat = aAcquisitionFormat;
    }

    @Override
    public String toString() {
        return "Awards{" +
                "aNo=" + aNo +
                ", rNo=" + rNo +
                ", aName='" + aName + '\'' +
                ", aDepartment='" + aDepartment + '\'' +
                ", aAcquisition=" + aAcquisition +
                ", aAcquisitionFormat='" + aAcquisitionFormat + '\'' +
                '}';
    }
}
