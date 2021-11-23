package com.kh.workPeople.common.vo;

import java.util.Date;

public class PromotionOrder {
	/*
	 * P_NO NUMBER No 1 주문번호 
	 * P_CODE NUMBER No 2 상품코드 
	 * P_START_DATE DATE No 3 시작일
	 * P_END_DATE DATE No 4 마감일 
	 * JV_NO NUMBER No 5 공고 번호 
	 * M_NO NUMBER No 6 회원번호
	 */
	
	private int pno;
	private int pcode;
	private Date pstartDate;
	private Date pendDate;
	private int jvno;
	private int mno;
	
	public PromotionOrder() {}
	
	public PromotionOrder(int pno, int pcode, Date pstartDate, Date pendDate, int jvno, int mno) {
		super();
		this.pno = pno;
		this.pcode = pcode;
		this.pstartDate = pstartDate;
		this.pendDate = pendDate;
		this.jvno = jvno;
		this.mno = mno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public Date getPstartDate() {
		return pstartDate;
	}

	public void setPstartDate(Date pstartDate) {
		this.pstartDate = pstartDate;
	}

	public Date getPendDate() {
		return pendDate;
	}

	public void setPendDate(Date pendDate) {
		this.pendDate = pendDate;
	}

	public int getJvno() {
		return jvno;
	}

	public void setJvno(int jvno) {
		this.jvno = jvno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "PromotionOrder [pno=" + pno + ", pcode=" + pcode + ", pstartDate=" + pstartDate + ", pendDate="
				+ pendDate + ", jvno=" + jvno + ", mno=" + mno + "]";
	}
	
	
	
	

}
