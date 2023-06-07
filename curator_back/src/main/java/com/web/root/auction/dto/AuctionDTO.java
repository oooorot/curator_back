package com.web.root.auction.dto;

public class AuctionDTO {
	
	// Field
	private int aucSeq;
	private int memberSeq;
	private int artistSeq;
	private int postSeq;
	private String auc_Nickname;
	private int auc_price;
	
	// Constructor
	public AuctionDTO() {}

	// Getter Setter
	public int getMemberSeq() {
		return memberSeq;
	}

	public int getAucSeq() {
		return aucSeq;
	}

	public void setAucSeq(int aucSeq) {
		this.aucSeq = aucSeq;
	}

	public int getArtistSeq() {
		return artistSeq;
	}

	public void setArtistSeq(int artistSeq) {
		this.artistSeq = artistSeq;
	}

	public int getPostSeq() {
		return postSeq;
	}

	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}

	public String getAuc_Nickname() {
		return auc_Nickname;
	}

	public void setAuc_Nickname(String auc_Nickname) {
		this.auc_Nickname = auc_Nickname;
	}

	public int getAuc_price() {
		return auc_price;
	}

	public void setAuc_price(int auc_price) {
		this.auc_price = auc_price;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	


	
}
