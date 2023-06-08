


package com.web.root.postExhibition.dto;

import java.sql.Timestamp;

public class PostExhibitionDTO {
	
	private int postSeq;
	private int genreSeq;
	private int artistSeq;
	private String postTitle;
	private String postSummary;
	private String postContent;
	private String postImageName;
	private int postPrice;
	private String postDate;
	private int postAuction;
	private int postExhibition;
	private int exhibitionSeq;
	private String exhibitionName;
	private Timestamp exhibitionDate;
	private String exhibitionExplain;
	private String exhibitionBanner;
	
	public PostExhibitionDTO() {
		super();
	}

	public PostExhibitionDTO(int postSeq, int genreSeq, int artistSeq, String postTitle, String postSummary,
			String postContent, String postImageName, int postPrice, String postDate, int postAuction,
			int postExhibition, int exhibitionSeq, String exhibitionName, Timestamp exhibitionDate,
			String exhibitionExplain, String exhibitionBanner) {
		super();
		this.postSeq = postSeq;
		this.genreSeq = genreSeq;
		this.artistSeq = artistSeq;
		this.postTitle = postTitle;
		this.postSummary = postSummary;
		this.postContent = postContent;
		this.postImageName = postImageName;
		this.postPrice = postPrice;
		this.postDate = postDate;
		this.postAuction = postAuction;
		this.postExhibition = postExhibition;
		this.exhibitionSeq = exhibitionSeq;
		this.exhibitionName = exhibitionName;
		this.exhibitionDate = exhibitionDate;
		this.exhibitionExplain = exhibitionExplain;
		this.exhibitionBanner = exhibitionBanner;
	}

	public int getPostSeq() {
		return postSeq;
	}

	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}

	public int getGenreSeq() {
		return genreSeq;
	}

	public void setGenreSeq(int genreSeq) {
		this.genreSeq = genreSeq;
	}

	public int getArtistSeq() {
		return artistSeq;
	}

	public void setArtistSeq(int artistSeq) {
		this.artistSeq = artistSeq;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostSummary() {
		return postSummary;
	}

	public void setPostSummary(String postSummary) {
		this.postSummary = postSummary;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostImageName() {
		return postImageName;
	}

	public void setPostImageName(String postImageName) {
		this.postImageName = postImageName;
	}

	public int getPostPrice() {
		return postPrice;
	}

	public void setPostPrice(int postPrice) {
		this.postPrice = postPrice;
	}

	

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public int getPostAuction() {
		return postAuction;
	}

	public void setPostAuction(int postAuction) {
		this.postAuction = postAuction;
	}

	public int getPostExhibition() {
		return postExhibition;
	}

	public void setPostExhibition(int postExhibition) {
		this.postExhibition = postExhibition;
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
