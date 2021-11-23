package com.kh.workPeople.common.vo;

public class PromotionCode {
	/*
	 * P_CODE NUMBER No 1 상품코드 
	 * P_NAME VARCHAR2(50 CHAR) No 2 상품명 
	 * P_PRICE NUMBER No 3 상품금액
	 */
	
	private int pcode;
	private String pname;
	private int pprice;

	public PromotionCode() {}

	public PromotionCode(int pcode, String pname, int pprice) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.pprice = pprice;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "PromotionCode [pcode=" + pcode + ", pname=" + pname + ", pprice=" + pprice + "]";
	}
	
	
}
