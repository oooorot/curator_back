package com.web.root.genre.dto;

public class GenreDTO {
	
	private int genreSeq;
	private String genreName;
	private String genreContent;
	
	public GenreDTO() {
		super();
	}

	public GenreDTO(int genreSeq, String genreName, String genreContent) {
		super();
		this.genreSeq = genreSeq;
		this.genreName = genreName;
		this.genreContent = genreContent;
	}

	public int getGenreSeq() {
		return genreSeq;
	}

	public void setGenreSeq(int genreSeq) {
		this.genreSeq = genreSeq;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getGenreContent() {
		return genreContent;
	}

	public void setGenreContent(String genreContent) {
		this.genreContent = genreContent;
	}
	
	

}
