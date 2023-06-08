package com.web.root.customer.dto;

public class BookmarkDTO {

	private int markSeq;
	private int memberSeq;
	private int artistSeq;
	
	public BookmarkDTO(int markSeq, int memberSeq, int artistSeq) {
		super();
		this.markSeq = markSeq;
		this.memberSeq = memberSeq;
		this.artistSeq = artistSeq;
	}

	public BookmarkDTO() {
		
	}

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

	public int getArtistSeq() {
		return artistSeq;
	}

	public void setArtistSeq(int artistSeq) {
		this.artistSeq = artistSeq;
	}
	
	
	
	
}
