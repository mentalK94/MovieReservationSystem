package model;

import type.MovieGenreType;
import type.MovieRatingType;

public class Movie {
	private String order; // 영화번호
	private String title; // 영화제목
	private MovieGenreType genre; // 영화장르
	private MovieRatingType rating; // 영화등급

	public Movie(String order, String title, MovieGenreType genre, MovieRatingType rating) {
		super();
		this.order = order;
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		System.out.println(order + " : " + order + ", "+ genre.getName() +", " + rating.getName());
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

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	public Movie getMovieFromOrder(String order) {
		return this;
	}

}
