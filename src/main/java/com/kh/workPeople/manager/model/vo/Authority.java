package com.kh.workPeople.manager.model.vo;

public class Authority {
	private int acode;
	private String aname;
	private String adesc;
	
	public Authority() {}

	public Authority(int acode, String aname, String adesc) {
		super();
		this.acode = acode;
		this.aname = aname;
		this.adesc = adesc;
	}


	public int getAcode() {
		return acode;
	}

	public void setAcode(int acode) {
		this.acode = acode;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAdesc() {
		return adesc;
	}

	public void setAdesc(String adesc) {
		this.adesc = adesc;
	}
	
	@Override
	public String toString() {
		return "Authority [acode=" + acode + ", aname=" + aname + ", adesc=" + adesc + "]";
	}

	
}