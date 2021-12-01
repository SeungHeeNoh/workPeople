package com.kh.workPeople.common.vo;

import java.util.Date;

public class License {

    private int lNo;                            // 자격증 번호
    private int rNo;                            // 이력서 번호
    private String lName;                       // 자격증명
    private String lDepartment;                 // 발행처,기관
    private String lPassYN;                    // 합격여부
    private Date lAcquisitionDate;              // 취득일

    private String lAcquisitionDateFormat;      // 취득일 포멧팅(YYYY.MM)

    public License() {
    }

    public License(int lNo, int rNo, String lName, String lDepartment, String lPassYN, Date lAcquisitionDate, String lAcquisitionDateFormat) {
        this.lNo = lNo;
        this.rNo = rNo;
        this.lName = lName;
        this.lDepartment = lDepartment;
        this.lPassYN = lPassYN;
        this.lAcquisitionDate = lAcquisitionDate;
        this.lAcquisitionDateFormat = lAcquisitionDateFormat;
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

    public String getlPassYN() {
        return lPassYN;
    }

    public void setlPassYN(String lPassYN) {
        this.lPassYN = lPassYN;
    }

    public Date getlAcquisitionDate() {
        return lAcquisitionDate;
    }

    public void setlAcquisitionDate(Date lAcquisitionDate) {
        this.lAcquisitionDate = lAcquisitionDate;
    }

    public String getlAcquisitionDateFormat() {
        return lAcquisitionDateFormat;
    }

    public void setlAcquisitionDateFormat(String lAcquisitionDateFormat) {
        this.lAcquisitionDateFormat = lAcquisitionDateFormat;
    }

    @Override
    public String toString() {
        return "License{" +
                "lNo=" + lNo +
                ", rNo=" + rNo +
                ", lName='" + lName + '\'' +
                ", lDepartment='" + lDepartment + '\'' +
                ", lPassYN=" + lPassYN +
                ", lAcquisitionDate=" + lAcquisitionDate +
                ", lAcquisitionDateFormat='" + lAcquisitionDateFormat + '\'' +
                '}';
    }
}
