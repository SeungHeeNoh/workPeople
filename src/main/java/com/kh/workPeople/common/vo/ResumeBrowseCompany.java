package com.kh.workPeople.common.vo;

import oracle.sql.CHAR;

import java.text.SimpleDateFormat;
import java.util.Date;

// 이력서 열람 기업 (입사지원 )
public class ResumeBrowseCompany {

    private int m_no;                   // 회원번호(기업)
    private String m_name;              // 기업이름
    private String m_roadAddress;       // 기업 주소
    private String s_name;              // 업종명
    private Date rb_date;               // 열람일

    private String rb_date_format;      // 열람일 형변환

    public ResumeBrowseCompany() {

    }

    public ResumeBrowseCompany(int m_no, String m_name, String m_roadAddress, String s_name, Date rb_date) {
        this.m_no = m_no;
        this.m_name = m_name;
        this.m_roadAddress = m_roadAddress;
        this.s_name = s_name;
        this.rb_date = rb_date;
    }




    public String getRb_date_format() {
        return rb_date_format;
    }

    public void setRb_date_format(String rb_date_format) {
        this.rb_date_format = rb_date_format;
    }




    public int getM_no() {
        return m_no;
    }

    public void setM_no(int m_no) {
        this.m_no = m_no;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_roadAddress() {
        return m_roadAddress;
    }

    public void setM_roadAddress(String m_roadAddress) {
        this.m_roadAddress = m_roadAddress;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Date getRb_date() {
        return rb_date;
    }

    public void setRb_date(Date rb_date) {
        this.rb_date = rb_date;
    }

    @Override
    public String toString() {
        return "resumeBrowseCompany{" +
                "m_no=" + m_no +
                ", m_name='" + m_name + '\'' +
                ", m_roadAddress='" + m_roadAddress + '\'' +
                ", s_name='" + s_name + '\'' +
                ", rb_date=" + rb_date +
                '}';
    }
}
