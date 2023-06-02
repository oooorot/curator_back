package com.web.root.customer.dto;

public class PurchaseDTO {

	// Field
	private int purSeq;
	private int memberSeq;
	private int postSeq;
	private String purName;
	private String purPhone;
	private String purAddr;
	private String purDate;
	
	// Constructor
	public PurchaseDTO() {}
	
	// Getter Setter
	public int getPurSeq() {
		return purSeq;
	}

	public void setPurSeq(int purSeq) {
		this.purSeq = purSeq;
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

	public String getPurName() {
		return purName;
	}

	public void setPurName(String purName) {
		this.purName = purName;
	}

	public String getPurPhone() {
		return purPhone;
	}

	public void setPurPhone(String purPhone) {
		this.purPhone = purPhone;
	}

	public String getPurAddr() {
		return purAddr;
	}

	public void setPurAddr(String purAddr) {
		this.purAddr = purAddr;
	}

	public String getPurDate() {
		return purDate;
	}

	public void setPurDate(String purDate) {
		this.purDate = purDate;
	}
}
