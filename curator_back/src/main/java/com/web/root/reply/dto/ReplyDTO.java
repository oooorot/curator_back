

package com.web.root.reply.dto;


public class ReplyDTO {
	
	private int replySeq;
	private int helpSeq;
	private int memberSeq;
	private String replyTitle;
	private String replyContent;
	private String replyDate;
	
	public ReplyDTO() {
		super();
	}

	public ReplyDTO(int replySeq, int helpSeq, int memberSeq, String replyTitle, String replyContent,
			String replyDate) {
		super();
		this.replySeq = replySeq;
		this.helpSeq = helpSeq;
		this.memberSeq = memberSeq;
		this.replyTitle = replyTitle;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}

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

	public String getReplyTitle() {
		return replyTitle;
	}

	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	
	
	

	
}
