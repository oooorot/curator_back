


package com.web.root.auction.dto;

public class AuctionDTO {
	
	
	private int aucSeq;
	private int memberSeq;
	private int artistSeq;
	private int postSeq;
	private String aucNickName;
	private int aucPrice;
	
	public AuctionDTO() {
		super();
	}

	public AuctionDTO(int aucSeq, int memberSeq, int artistSeq, int postSeq, String aucNickName, int aucPrice) {
		super();
		this.aucSeq = aucSeq;
		this.memberSeq = memberSeq;
		this.artistSeq = artistSeq;
		this.postSeq = postSeq;
		this.aucNickName = aucNickName;
		this.aucPrice = aucPrice;
	}

	public int getAucSeq() {
		return aucSeq;
	}

	public void setAucSeq(int aucSeq) {
		this.aucSeq = aucSeq;
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

	public int getPostSeq() {
		return postSeq;
	}

	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}

	public String getAucNickName() {
		return aucNickName;
	}

	public void setAucNickName(String aucNickName) {
		this.aucNickName = aucNickName;
	}

	public int getAucPrice() {
		return aucPrice;
	}

	public void setAucPrice(int aucPrice) {
		this.aucPrice = aucPrice;
	}
	
	

}
