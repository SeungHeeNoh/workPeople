package com.kh.workPeople.common.vo;

public class scrapCompany {
	/*M_NO	NUMBER	No		1	회원번호(기업)
	R_NO	NUMBER	No		2	이력서번호*/
	private int mno;
	private int rno;
	
	public scrapCompany() {}

	public scrapCompany(int mno, int rno) {
		super();
		this.mno = mno;
		this.rno = rno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	@Override
	public String toString() {
		return "scrapCompany [mno=" + mno + ", rno=" + rno + "]";
	}
	
	

}
