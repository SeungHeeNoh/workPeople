package com.kh.workPeople.common.vo;

import java.util.Date;

public class Payment {
	/*
	 * PAY_NO NUMBER No 1 결제번호 
	 * P_NO NUMBER No 2 주문번호 
	 * PAY_DATE DATE No 3 결제일
	 * PAY_PRICE NUMBER No 4 결제금액 
	 * PAY_METHOD VARCHAR2(50 CHAR) No 5 결제방법 
	 * PAY_DETAIL VARCHAR2(50 CHAR) Yes 6 결제세부내용
	 */
	
	private int payno;
	private int pno;
	private Date payDate;
	private int payPrice;
	private String payMethod;
	private String payDetail;
	
	public Payment() {}

	public Payment(int payno, int pno, Date payDate, int payPrice, String payMethod, String payDetail) {
		super();
		this.payno = payno;
		this.pno = pno;
		this.payDate = payDate;
		this.payPrice = payPrice;
		this.payMethod = payMethod;
		this.payDetail = payDetail;
	}

	public int getPayno() {
		return payno;
	}

	public void setPayno(int payno) {
		this.payno = payno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getPayDetail() {
		return payDetail;
	}

	public void setPayDetail(String payDetail) {
		this.payDetail = payDetail;
	}

	@Override
	public String toString() {
		return "Payment [payno=" + payno + ", pno=" + pno + ", payDate=" + payDate + ", payPrice=" + payPrice
				+ ", payMethod=" + payMethod + ", payDetail=" + payDetail + "]";
	}
	
	


}
