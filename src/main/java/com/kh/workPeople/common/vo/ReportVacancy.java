package com.kh.workPeople.common.vo;


public class ReportVacancy {
	private int rvNo;
	private int mNo;
	private int jvNo;
	
	public ReportVacancy() {}

	public ReportVacancy(int rvNo, int mNo, int jvNo) {
		super();
		this.rvNo = rvNo;
		this.mNo = mNo;
		this.jvNo = jvNo;
	}

	public int getRvNo() {
		return rvNo;
	}

	public void setRvNo(int rvNo) {
		this.rvNo = rvNo;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getJvNo() {
		return jvNo;
	}

	public void setJvNo(int jvNo) {
		this.jvNo = jvNo;
	}

	@Override
	public String toString() {
		return "ReportVacancy [rvNo=" + rvNo + ", mNo=" + mNo + ", jvNo=" + jvNo + "]";
	}
	
	
	
	
}
