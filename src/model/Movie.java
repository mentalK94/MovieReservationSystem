package model;

import type.MovieGenreType;
import type.MovieRatingType;

public class Movie {
	private String code; // 영화코드
	private String title; // 영화제목
	private MovieGenreType genre; // 영화장르
	private MovieRatingType rating; // 영화등급

	public Movie(String code, String title, MovieGenreType genre, MovieRatingType rating) {
		super();
		this.code = code;
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		System.out.println(code + " : " + "[" + title + "]" + ", "+ genre.getName() +", " + rating.getName());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MovieGenreType getGenre() {
		return genre;
	}

	public void setGenre(MovieGenreType genre) {
		this.genre = genre;
	}

	public MovieRatingType getRating() {
		return rating;
	}

	public void setRating(MovieRatingType rating) {
		this.rating = rating;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Movie getMovieFromOrder(String order) {
		return this;
	}
	
	public void showMovieFromOrder() {
		Message.showFromString("************************");
		Message.showFromString(this.title);
		Message.showFromString("장르 : " + this.genre.getName());
		Message.showFromString("등급 : " + this.rating.getName());
		Message.showFromString("************************");
		Message.showFromString("\n");
	}
	

}
