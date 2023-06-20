package com.web.root.payment.dto;

public class successDTO {
	
	private String tid;
	private int memberSeq;
	private int postSeq;
	
	public successDTO() {
		super();
	}
	
	public successDTO(String tid, int memberSeq, int postSeq) {
		super();
		this.tid = tid;
		this.memberSeq = memberSeq;
		this.postSeq = postSeq;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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
