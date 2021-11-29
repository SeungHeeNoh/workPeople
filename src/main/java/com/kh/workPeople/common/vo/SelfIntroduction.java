package com.kh.workPeople.common.vo;

public class SelfIntroduction {

    private int siNo;               // 자기소개서 번호
    private int rNo;                // 이력서 번호
    private String siTitle;         // 자소서 항목 제목
    private String siContent;       // 자소서 항목 내용

    public SelfIntroduction() {
    }

    public SelfIntroduction(int siNo, int rNo, String siTitle, String siContent) {
        this.siNo = siNo;
        this.rNo = rNo;
        this.siTitle = siTitle;
        this.siContent = siContent;
    }

    public int getSiNo() {
        return siNo;
    }

    public void setSiNo(int siNo) {
        this.siNo = siNo;
    }

    public int getrNo() {
        return rNo;
    }

    public void setrNo(int rNo) {
        this.rNo = rNo;
    }

    public String getSiTitle() {
        return siTitle;
    }

    public void setSiTitle(String siTitle) {
        this.siTitle = siTitle;
    }

    public String getSiContent() {
        return siContent;
    }

    public void setSiContent(String siContent) {
        this.siContent = siContent;
    }

    @Override
    public String toString() {
        return "SelfIntroduction{" +
                "siNo=" + siNo +
                ", rNo=" + rNo +
                ", siTitle='" + siTitle + '\'' +
                ", siContent='" + siContent + '\'' +
                '}';
    }
}
