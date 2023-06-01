package com.web.root.reply.dto;

import java.sql.Timestamp;

public class ReplyDTO {
	
	// Field
	private int replySeq;
	private int helpSeq;
	private int memberSeq;
	private String replyTile;
	private String replyContent;
	private Timestamp replyDate;
	
	// Constructor
	public ReplyDTO() {}
	
	// Getter Setter
	public int getReplySeq() {
		return replySeq;
	}

	public void setReplySeq(int replySeq) {
		this.replySeq = replySeq;
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

	public String getReplyTile() {
		return replyTile;
	}

	public void setReplyTile(String replyTile) {
		this.replyTile = replyTile;
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
