package com.web.root.exhibition.dto;

import java.sql.Timestamp;

public class ExhibitionDTO {
	
	private int exhibitionSeq;
	private String exhibitionName;
	private Timestamp exhibitionDate;
	private String exhibitionExplain;
	private String exhibitionBanner;
	
	public ExhibitionDTO() {
		super();
	}

	public ExhibitionDTO(int exhibitionSeq, String exhibitionName, Timestamp exhibitionDate, String exhibitionExplain,
			String exhibitionBanner) {
		super();
		this.exhibitionSeq = exhibitionSeq;
		this.exhibitionName = exhibitionName;
		this.exhibitionDate = exhibitionDate;
		this.exhibitionExplain = exhibitionExplain;
		this.exhibitionBanner = exhibitionBanner;
	}

	public int getExhibitionSeq() {
		return exhibitionSeq;
	}

	public void setExhibitionSeq(int exhibitionSeq) {
		this.exhibitionSeq = exhibitionSeq;
	}

	public String getExhibitionName() {
		return exhibitionName;
	}

	public void setExhibitionName(String exhibitionName) {
		this.exhibitionName = exhibitionName;
	}

	public Timestamp getExhibitionDate() {
		return exhibitionDate;
	}

	public void setExhibitionDate(Timestamp exhibitionDate) {
		this.exhibitionDate = exhibitionDate;
	}

	public String getExhibitionExplain() {
		return exhibitionExplain;
	}

	public void setExhibitionExplain(String exhibitionExplain) {
		this.exhibitionExplain = exhibitionExplain;
	}

	public String getExhibitionBanner() {
		return exhibitionBanner;
	}

	public void setExhibitionBanner(String exhibitionBanner) {
		this.exhibitionBanner = exhibitionBanner;
	}
	
	

	
	
	
	
	
	
	

}
