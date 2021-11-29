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

    public Awards(int aNo, int rNo, String aName, String aDepartment, Date aAcquisition) {
        this.aNo = aNo;
        this.rNo = rNo;
        this.aName = aName;
        this.aDepartment = aDepartment;
        this.aAcquisition = aAcquisition;
    }

    public Awards(int aNo, int rNo, String aName, String aDepartment, Date aAcquisition, String aAcquisitionFormat) {
        this.aNo = aNo;
        this.rNo = rNo;
        this.aName = aName;
        this.aDepartment = aDepartment;
        this.aAcquisition = aAcquisition;
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
                '}';
    }
}
