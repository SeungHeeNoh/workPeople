package com.kh.workPeople.common.vo;

public class Authority {
	private int code;
	private String name;
	private String desc;
	
	public Authority() {}
	
	public Authority(int code, String name, String desc) {
		super();
		this.code = code;
		this.name = name;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Authority [code=" + code + ", name=" + name + ", desc=" + desc + "]";
	}
}
