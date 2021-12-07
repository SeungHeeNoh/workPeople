package com.kh.workPeople.common.vo;

import java.util.Date;
import java.util.List;

public class MainTier {

	private int jvNo;
	private String companyName;
	private String title;
	private String path;
	private String fileName;
	private List<MainTier> list;
	private int size;

    public MainTier() {
		
	}

	
	public MainTier(int jvNo, String companyName, String title, String path, String fileName, List<MainTier> list,
			int size) {
		super();
		this.jvNo = jvNo;
		this.companyName = companyName;
		this.title = title;
		this.path = path;
		this.fileName = fileName;
		this.list = list;
		this.size = size;
	}

	public int getJvNo() {
		return jvNo;
	}


	public void setJvNo(int jvNo) {
		this.jvNo = jvNo;
	}


	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<MainTier> getList() {
		return list;
	}

	public void setList(List<MainTier> list) {
		this.list = list;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "MainTier [jvNo=" + jvNo + ", companyName=" + companyName + ", title=" + title + ", path=" + path
				+ ", fileName=" + fileName + ", list=" + list + ", size=" + size + "]";
	}


}
