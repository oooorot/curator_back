package com.web.root.artist.dto;

public class ArtistDTO {

	private int artistSeq;
	private String artistName;
	private String artistProfile;
	private String artistSns;
	private String artistImage;
	private int artistHit;
	
	public ArtistDTO() {
		super();
	}
	
	public ArtistDTO(int artistSeq, String artistName, String artistProfile, String artistSns, String artistImage,
			int artistHit) {
		super();
		this.artistSeq = artistSeq;
		this.artistName = artistName;
		this.artistProfile = artistProfile;
		this.artistSns = artistSns;
		this.artistImage = artistImage;
		this.artistHit = artistHit;
	}

	public int getArtistSeq() {
		return artistSeq;
	}

	public void setArtistSeq(int artistSeq) {
		this.artistSeq = artistSeq;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistProfile() {
		return artistProfile;
	}

	public void setArtistProfile(String artistProfile) {
		this.artistProfile = artistProfile;
	}

	public String getArtistSns() {
		return artistSns;
	}

	public void setArtistSns(String artistSns) {
		this.artistSns = artistSns;
	}

	public String getArtistImage() {
		return artistImage;
	}

	public void setArtistImage(String artistImage) {
		this.artistImage = artistImage;
	}

	public int getArtistHit() {
		return artistHit;
	}

	public void setArtistHit(int artistHit) {
		this.artistHit = artistHit;
	}
	
	
	
	
	
	
	
	
}
