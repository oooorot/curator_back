package com.web.root.auction.dto;

public class PriceDTO {
	
	private int memberSeq;
	private int postSeq;
	private int aucPrice;
	
	public PriceDTO() {}
	
	public PriceDTO(int memberSeq, int postSeq, int aucPrice) {
		super();
		this.memberSeq = memberSeq;
		this.postSeq = postSeq;
		this.aucPrice = aucPrice;
	}

	public int getPostSeq() {
		return postSeq;
	}

	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getAucPrice() {
		return aucPrice;
	}

	public void setAucPrice(int aucPrice) {
		this.aucPrice = aucPrice;
	}
	
	
	
	
	
	
	
	
}
