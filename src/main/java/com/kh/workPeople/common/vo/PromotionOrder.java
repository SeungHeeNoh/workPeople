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
	private Date pstartDate;
	private Date pendDate;
	private int jvno;
	private int mno;
	private int day; 
	private PromotionCode pCode;
	private Payment payment;
	private JobVacancyLookUp jobVacancyLookUp;
	
	public PromotionOrder() {}

	public PromotionOrder(int pno, Date pstartDate, Date pendDate, int jvno, int mno, int day, PromotionCode pCode,
			Payment payment, JobVacancyLookUp jobVacancyLookUp) {
		super();
		this.pno = pno;
		this.pstartDate = pstartDate;
		this.pendDate = pendDate;
		this.jvno = jvno;
		this.mno = mno;
		this.day = day;
		this.pCode = pCode;
		this.payment = payment;
		this.jobVacancyLookUp = jobVacancyLookUp;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public PromotionCode getpCode() {
		return pCode;
	}

	public void setpCode(PromotionCode pCode) {
		this.pCode = pCode;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public JobVacancyLookUp getJobVacancyLookUp() {
		return jobVacancyLookUp;
	}

	public void setJobVacancyLookUp(JobVacancyLookUp jobVacancyLookUp) {
		this.jobVacancyLookUp = jobVacancyLookUp;
	}

	@Override
	public String toString() {
		return "PromotionOrder [pno=" + pno + ", pstartDate=" + pstartDate + ", pendDate=" + pendDate + ", jvno=" + jvno
				+ ", mno=" + mno + ", day=" + day + ", pCode=" + pCode + ", payment=" + payment + ", jobVacancyLookUp="
				+ jobVacancyLookUp + "]";
	}

	

	
	
	

}
