package com.kh.workPeople.common.vo;

import java.util.Date;

public class Career {

    private int acNo;                   // 입사지원 구분 번호
    private int cNo;                                // 경력 번호
    private int rNo;                                // 이력서 번호
    private String cYn;                             // 경력 여부
    private String cName;                           // 회사 이름
    private Date cEmploymentDate;                   // 취직 년월
    private Date cUnemploymentDate;                 // 실직 년월

    private String cEmploymentDateFormat;           // 취직 년월 문자열 포멧팅(ex : 2000.02)
    private String cUnemploymentDateFormat;         // 실직 년월 문자열 포멧팅(ex : 2000.02)

    private String cPosition;                       // 직급,직책
    private String cDepartment;                     // 근무 부서
    private String cTask;                           // 담당 업무
    private String cReSignation;                    // 퇴사 사유

    public Career() {
    }

    public Career(int cNo, int rNo, String cYn, String cName, Date cEmploymentDate, Date cUnemploymentDate, String cPosition, String cDepartment, String cTask, String cReSignation) {
        this.cNo = cNo;
        this.rNo = rNo;
        this.cYn = cYn;
        this.cName = cName;
        this.cEmploymentDate = cEmploymentDate;
        this.cUnemploymentDate = cUnemploymentDate;
        this.cPosition = cPosition;
        this.cDepartment = cDepartment;
        this.cTask = cTask;
        this.cReSignation = cReSignation;
    }

    public Career(int cNo, int rNo, String cYn, String cName, Date cEmploymentDate, Date cUnemploymentDate, String cEmploymentDateFormat, String cUnemploymentDateFormat, String cPosition, String cDepartment, String cTask, String cReSignation) {
        this.cNo = cNo;
        this.rNo = rNo;
        this.cYn = cYn;
        this.cName = cName;
        this.cEmploymentDate = cEmploymentDate;
        this.cUnemploymentDate = cUnemploymentDate;
        this.cEmploymentDateFormat = cEmploymentDateFormat;
        this.cUnemploymentDateFormat = cUnemploymentDateFormat;
        this.cPosition = cPosition;
        this.cDepartment = cDepartment;
        this.cTask = cTask;
        this.cReSignation = cReSignation;
    }

    public Career(int acNo, int cNo, int rNo, String cYn, String cName, Date cEmploymentDate, Date cUnemploymentDate, String cEmploymentDateFormat, String cUnemploymentDateFormat, String cPosition, String cDepartment, String cTask, String cReSignation) {
        this.acNo = acNo;
        this.cNo = cNo;
        this.rNo = rNo;
        this.cYn = cYn;
        this.cName = cName;
        this.cEmploymentDate = cEmploymentDate;
        this.cUnemploymentDate = cUnemploymentDate;
        this.cEmploymentDateFormat = cEmploymentDateFormat;
        this.cUnemploymentDateFormat = cUnemploymentDateFormat;
        this.cPosition = cPosition;
        this.cDepartment = cDepartment;
        this.cTask = cTask;
        this.cReSignation = cReSignation;
    }

    public int getAcNo() {
        return acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public int getcNo() {
        return cNo;
    }

    public void setcNo(int cNo) {
        this.cNo = cNo;
    }

    public int getrNo() {
        return rNo;
    }

    public void setrNo(int rNo) {
        this.rNo = rNo;
    }

    public String getcYn() {
        return cYn;
    }

    public void setcYn(String cYn) {
        this.cYn = cYn;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Date getcEmploymentDate() {
        return cEmploymentDate;
    }

    public void setcEmploymentDate(Date cEmploymentDate) {
        this.cEmploymentDate = cEmploymentDate;
    }

    public Date getcUnemploymentDate() {
        return cUnemploymentDate;
    }

    public void setcUnemploymentDate(Date cUnemploymentDate) {
        this.cUnemploymentDate = cUnemploymentDate;
    }

    public String getcEmploymentDateFormat() {
        return cEmploymentDateFormat;
    }

    public void setcEmploymentDateFormat(String cEmploymentDateFormat) {
        this.cEmploymentDateFormat = cEmploymentDateFormat;
    }

    public String getcUnemploymentDateFormat() {
        return cUnemploymentDateFormat;
    }

    public void setcUnemploymentDateFormat(String cUnemploymentDateFormat) {
        this.cUnemploymentDateFormat = cUnemploymentDateFormat;
    }

    public String getcPosition() {
        return cPosition;
    }

    public void setcPosition(String cPosition) {
        this.cPosition = cPosition;
    }

    public String getcDepartment() {
        return cDepartment;
    }

    public void setcDepartment(String cDepartment) {
        this.cDepartment = cDepartment;
    }

    public String getcTask() {
        return cTask;
    }

    public void setcTask(String cTask) {
        this.cTask = cTask;
    }

    public String getcReSignation() {
        return cReSignation;
    }

    public void setcReSignation(String cReSignation) {
        this.cReSignation = cReSignation;
    }

    @Override
    public String toString() {
        return "Career{" +
                "cNo=" + cNo +
                ", rNo=" + rNo +
                ", cYn='" + cYn + '\'' +
                ", cName='" + cName + '\'' +
                ", cEmploymentDate=" + cEmploymentDate +
                ", cUnemploymentDate=" + cUnemploymentDate +
                ", cPosition='" + cPosition + '\'' +
                ", cDepartment='" + cDepartment + '\'' +
                ", cTask='" + cTask + '\'' +
                ", cReSignation='" + cReSignation + '\'' +
                '}';
    }
}
