package com.kh.workPeople.common.vo;

public class Sector {
	private int no;
	private String name;
	
	public Sector() {}

	public Sector(int no, String name) {
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
		return "Sector [no=" + no + ", name=" + name + "]";
	}
}
