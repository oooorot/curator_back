


package com.web.root.post.dto;


public class PostAuctionDTO {

	private int postSeq;
	private int genreSeq;
	private int artistSeq;
	private String postTitle;
	private String postSummary;
	private String postContent;
	private String postImageName;
	private int postPrice;
	private String postDate;
	private int postExhibition;
	private int postAuction;
	private int aucSeq;
	private int memberSeq;
	private String aucNickName;
	private int aucPrice;

	
	
	public PostAuctionDTO() {}

	public int getPostSeq() {
		return postSeq;
	}


	public int getPostExhibition() {
		return postExhibition;
	}

	public void setPostExhibition(int postExhibition) {
		this.postExhibition = postExhibition;
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
	
	public int getPostAuction() {
		return postAuction;
	}

	public void setPostAuction(int postAuction) {
		this.postAuction = postAuction;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	

}
