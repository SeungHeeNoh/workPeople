package com.kh.workPeople.common.vo;

public class ExperienceLevel {
	
	private int no;
	private String name;
	
	public ExperienceLevel() {}

	public ExperienceLevel(int no, String name) {
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
		return "ExperienceLevel [no=" + no + ", name=" + name + "]";
	}
	
}
