package com.hilla.daniel.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class OldSong {
	
	@Size(min = 3, max = 20)
	private String title;
	
	@Size(min = 3, max = 20)
	private String artist;
	
	@Min(1)
	@Max(10)
	private int rating;

	public OldSong() {

	}

	public OldSong(String _title, String _artist, int _rating) {
		setTitle(_title);
		setArtist(_artist);
		setRating(_rating);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		if (rating > 10) {
			this.rating = 10;
		} else if (rating < 1) {
			this.rating = 1;
		} else {
			this.rating = rating;
		}
	}

}
