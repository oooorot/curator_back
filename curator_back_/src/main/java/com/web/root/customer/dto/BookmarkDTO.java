package com.web.root.customer.dto;

public class BookmarkDTO {
	
	// Field
	private int markSeq;
	private int memberSeq;
	private int postSeq;
	
	// Constructor
	public BookmarkDTO() {}
	
	// Getter Setter
	public int getMarkSeq() {
		return markSeq;
	}

	public void setMarkSeq(int markSeq) {
		this.markSeq = markSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getPostSeq() {
		return postSeq;
	}

	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}

}
