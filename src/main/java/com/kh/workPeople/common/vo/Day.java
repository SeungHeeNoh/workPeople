package com.kh.workPeople.common.vo;

public class Day {

	private int no;
	private String name;
	
	public Day() {}

	public Day(int no, String name) {
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
		return "Day [no=" + no + ", name=" + name + "]";
	}
	
}
