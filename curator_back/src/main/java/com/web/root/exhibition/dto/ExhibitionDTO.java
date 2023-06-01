package com.web.root.exhibition.dto;

import java.sql.Timestamp;

public class ExhibitionDTO {
	
	private int exhibition_seq;
	private String exhibition_Name;
	private Timestamp exhibition_Date;
	private String exhibition_Explain;
	private String exhibition_Banner;
	
	public ExhibitionDTO() {
		super();
	}

	public ExhibitionDTO(int exhibition_seq, String exhibition_Name, Timestamp exhibition_Date,
			String exhibition_Explain, String exhibition_Banner) {
		super();
		this.exhibition_seq = exhibition_seq;
		this.exhibition_Name = exhibition_Name;
		this.exhibition_Date = exhibition_Date;
		this.exhibition_Explain = exhibition_Explain;
		this.exhibition_Banner = exhibition_Banner;
	}

	public int getExhibition_seq() {
		return exhibition_seq;
	}

	public void setExhibition_seq(int exhibition_seq) {
		this.exhibition_seq = exhibition_seq;
	}

	public String getExhibition_Name() {
		return exhibition_Name;
	}

	public void setExhibition_Name(String exhibition_Name) {
		this.exhibition_Name = exhibition_Name;
	}

	public Timestamp getExhibition_Date() {
		return exhibition_Date;
	}

	public void setExhibition_Date(Timestamp exhibition_Date) {
		this.exhibition_Date = exhibition_Date;
	}

	public String getExhibition_Explain() {
		return exhibition_Explain;
	}

	public void setExhibition_Explain(String exhibition_Explain) {
		this.exhibition_Explain = exhibition_Explain;
	}

	public String getExhibition_Banner() {
		return exhibition_Banner;
	}

	public void setExhibition_Banner(String exhibition_Banner) {
		this.exhibition_Banner = exhibition_Banner;
	}
	
	
	
	
	
	

}
