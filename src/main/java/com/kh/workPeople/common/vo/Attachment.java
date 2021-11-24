package com.kh.workPeople.common.vo;

import java.util.Date;

public class Attachment {

	private int no;
	private String originName;
	private String changeName;
	private String filePath;
	private String status;
	private Date create;
	private Date update;
	
	public Attachment() {}

	public Attachment(int no, String originName, String changeName, String filePath, String status, Date create, Date update) {
		super();
		this.no = no;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.status = status;
		this.create = create;
		this.update = update;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	@Override
	public String toString() {
		return "Attachment [no=" + no + ", originName=" + originName + ", changeName=" + changeName + ", filePath="
				+ filePath + ", status=" + status + ", create=" + create + ", update=" + update + "]";
	}
	
	
}
