package com.web.root.customer.dto;

import java.sql.Timestamp;

public class CustomerHelpDTO {
	
	// Field
	private int helpSeq;
	private int memberSeq;
	private String helpTitle;
	private String helpContent;
	private Timestamp helpDate;
	private int replySeq;
	private String replyTitle;
	private String replyContent;
	private Timestamp replyDate;
	
	// Constructor
	public CustomerHelpDTO() {}
	
	// Getter Setter
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

	public Timestamp getHelpDate() {
		return helpDate;
	}

	public void setHelpDate(Timestamp helpDate) {
		this.helpDate = helpDate;
	}

	public int getReplySeq() {
		return replySeq;
	}

	public void setReplySeq(int replySeq) {
		this.replySeq = replySeq;
	}

	public String getReplyTitle() {
		return replyTitle;
	}

	public void setReplyTile(String replyTitle) {
		this.replyTitle = replyTitle;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}
	

}
