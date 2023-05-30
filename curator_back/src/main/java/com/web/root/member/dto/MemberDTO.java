package com.web.root.member.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MemberDTO {
	
	// MemberField
	private int memberSeq;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String memberName;
	private String memberPhone;
	private String memberAddr;
	private int memberGrade;
	private String memberDate;
	
	// Constructor
	public MemberDTO() {}
	
	// Getter Setter
	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}


	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}

	public String getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Timestamp memberDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		this.memberDate = dateFormat.format(memberDate);
	}
	


	
	

}
