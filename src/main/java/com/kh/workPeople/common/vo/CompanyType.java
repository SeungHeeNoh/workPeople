package com.kh.workPeople.common.vo;

public class CompanyType {
	private int no;
	private String name;
	
	public CompanyType() {}

	public CompanyType(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CompanyType [no=" + no + ", name=" + name + "]";
	}
	
	
}
