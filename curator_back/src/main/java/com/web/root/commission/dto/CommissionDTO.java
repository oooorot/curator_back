package com.web.root.commission.dto;

import java.sql.Timestamp;

public class CommissionDTO {

	private int commSeq;
	private int artistSeq;
	private int memberSeq;
	private String commTitle;
	private String commContent;
	private String commImage;
	private Timestamp commDate;
	
	public CommissionDTO() {
		super();
	}
	
	public CommissionDTO(int commSeq, int artistSeq, int memberSeq, String commTitle, String commContent,
			String commImage, Timestamp commDate) {
		super();
		this.commSeq = commSeq;
		this.artistSeq = artistSeq;
		this.memberSeq = memberSeq;
		this.commTitle = commTitle;
		this.commContent = commContent;
		this.commImage = commImage;
		this.commDate = commDate;
	}

	public int getCommSeq() {
		return commSeq;
	}

	public void setCommSeq(int commSeq) {
		this.commSeq = commSeq;
	}

	public int getArtistSeq() {
		return artistSeq;
	}

	public void setArtistSeq(int artistSeq) {
		this.artistSeq = artistSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getCommTitle() {
		return commTitle;
	}

	public void setCommTitle(String commTitle) {
		this.commTitle = commTitle;
	}

	public String getCommContent() {
		return commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public String getCommImage() {
		return commImage;
	}

	public void setCommImage(String commImage) {
		this.commImage = commImage;
	}

	public Timestamp getCommDate() {
		return commDate;
	}

	public void setCommDate(Timestamp commDate) {
		this.commDate = commDate;
	}
	
	
	
	
	
}
