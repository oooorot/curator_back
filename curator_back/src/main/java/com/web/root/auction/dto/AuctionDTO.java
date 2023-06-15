


package com.web.root.auction.dto;

public class AuctionDTO {
	
	
	private int aucSeq;
	private int memberSeq;
	private int artistSeq;
	private int postSeq;
	private String aucNickname;
	private int aucPrice;
	
	public AuctionDTO() {
		super();
	}

	public AuctionDTO(int aucSeq, int memberSeq, int artistSeq, int postSeq, String aucNickname, int aucPrice) {
		super();
		this.aucSeq = aucSeq;
		this.memberSeq = memberSeq;
		this.artistSeq = artistSeq;
		this.postSeq = postSeq;
		this.aucNickname = aucNickname;
		this.aucPrice = aucPrice;
	}
	
	public AuctionDTO(int memberSeq, int postSeq) {
		super();
		this.memberSeq = memberSeq;
		this.postSeq = postSeq;
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
		return aucNickname;
	}

	public void setAucNickName(String aucNickName) {
		this.aucNickname = aucNickName;
	}

	public int getAucPrice() {
		return aucPrice;
	}

	public void setAucPrice(int aucPrice) {
		this.aucPrice = aucPrice;
	}
	
	

}
