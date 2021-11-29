package com.kh.workPeople.common.vo;

import java.util.Date;

// 이력서 간편 조회 항목
public class Resume {

    private int no;                     // 이력서 번호
    private Date enrollDate;            // 등록일
    private String statusYN;            // 대표이력서여부
    private String deleteYN;            // 이력서 삭제 여부
    private String title;               // 이력서제목
    private String s_name;              // 업종명

    private String enrollDateFormat;    // 등록일을 YYYY.MM.dd 문자열로 저장할 변수

    public Resume() {
    }

    public Resume(int no, Date enrollDate, String statusYN, String title, String s_name) {
        this.no = no;
        this.enrollDate = enrollDate;
        this.statusYN = statusYN;
        this.title = title;
        this.s_name = s_name;
    }

    public String getDeleteYN() {
        return deleteYN;
    }

    public void setDeleteYN(String deleteYN) {
        this.deleteYN = deleteYN;
    }

    public String getEnrollDateFormat() {
        return enrollDateFormat;
    }

    public void setEnrollDateFormat(String enrollDateFormat) {
        this.enrollDateFormat = enrollDateFormat;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getStatusYN() {
        return statusYN;
    }

    public void setStatusYN(String statusYN) {
        this.statusYN = statusYN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    @Override
    public String toString() {
        return "resume{" +
                "no=" + no +
                ", enrollDate=" + enrollDate +
                ", statusYN='" + statusYN + '\'' +
                ", title='" + title + '\'' +
                ", s_name='" + s_name + '\'' +
                '}';
    }
}
