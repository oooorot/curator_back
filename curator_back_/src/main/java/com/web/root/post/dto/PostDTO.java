

package com.web.root.post.dto;

import java.sql.Timestamp;

public class PostDTO {
	
	private int postSeq;
	private int genreSeq;
	private int artistSeq;
	private String postTitle;
	private String postSummary;
	private String postContent;
	private String postImageName;
	private int postPrice;
	private Timestamp postDate;
	
	public PostDTO() {
		super();
	}

	public PostDTO(int postSeq, int genreSeq, int artistSeq, String postTitle, String postSummary, String postContent,
			String postImageName, int postPrice, Timestamp postDate) {
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

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
	
	
	
	
	
	

}
