package com.web.root.nonmember.dto;

import java.sql.Timestamp;

public class NonmemberDTO {

	private int nonSeq;
	private String nonCode;
	private String nonEmail;
	private String nonName;
	private String nonPhone;
	private String nonAddr;
	private Timestamp nonDate;
	
	public NonmemberDTO() {
		
	}

	public NonmemberDTO(int nonSeq, String nonCode, String nonEmail, String nonName, String nonPhone, String nonAddr,
			Timestamp nonDate) {
		super();
		this.nonSeq = nonSeq;
		this.nonCode = nonCode;
		this.nonEmail = nonEmail;
		this.nonName = nonName;
		this.nonPhone = nonPhone;
		this.nonAddr = nonAddr;
		this.nonDate = nonDate;
	}

	public int getNonSeq() {
		return nonSeq;
	}

	public void setNonSeq(int nonSeq) {
		this.nonSeq = nonSeq;
	}

	public String getNonCode() {
		return nonCode;
	}

	public void setNonCode(String nonCode) {
		this.nonCode = nonCode;
	}

	public String getNonEmail() {
		return nonEmail;
	}

	public void setNonEmail(String nonEmail) {
		this.nonEmail = nonEmail;
	}

	public String getNonName() {
		return nonName;
	}

	public void setNonName(String nonName) {
		this.nonName = nonName;
	}

	public String getNonPhone() {
		return nonPhone;
	}

	public void setNonPhone(String nonPhone) {
		this.nonPhone = nonPhone;
	}

	public String getNonAddr() {
		return nonAddr;
	}

	public void setNonAddr(String nonAddr) {
		this.nonAddr = nonAddr;
	}

	public Timestamp getNonDate() {
		return nonDate;
	}

	public void setNonDate(Timestamp nonDate) {
		this.nonDate = nonDate;
	}

	
	
	
}
