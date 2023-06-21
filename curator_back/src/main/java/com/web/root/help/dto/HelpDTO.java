package com.web.root.help.dto;

import java.sql.Timestamp;

public class HelpDTO {

	private int helpSeq;
	private int memberSeq;
	private String helpTitle;
	private String helpContent;
	private String helpDate;
	private String helpCate;
	
	public HelpDTO() {}

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

	public String getHelpCate() {
		return helpCate;
	}

	public void setHelpCate(String helpCate) {
		this.helpCate = helpCate;
	}
	
}
