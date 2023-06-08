package com.web.root.service.dto;

import java.sql.Timestamp;

public class ServiceDTO {

	private int helpSeq;
	private int memberSeq;
	private String helpTitle;
	private String helpContent;
	private String helpDate;
	
	public ServiceDTO() {
		super();
	}

	public ServiceDTO(int helpSeq, int memberSeq, String helpTitle, String helpContent, String helpDate) {
		super();
		this.helpSeq = helpSeq;
		this.memberSeq = memberSeq;
		this.helpTitle = helpTitle;
		this.helpContent = helpContent;
		this.helpDate = helpDate;
	}

	public int getHelpSeq() {
		return helpSeq;
	}

	public void setHelpSeq(int helpSeq) {
		this.helpSeq = helpSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getHelpTitle() {
		return helpTitle;
	}

	public void setHelpTitle(String helpTitle) {
		this.helpTitle = helpTitle;
	}

	public String getHelpContent() {
		return helpContent;
	}

	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}

	public String getHelpDate() {
		return helpDate;
	}

	public void setHelpDate(String helpDate) {
		this.helpDate = helpDate;
	}
	
	


	
	
	
}
