// 영화리스트와 예약자를 가지고 있는 모델
// 

package model;

import java.util.ArrayList;
import java.util.HashMap;

import type.MovieGenreType;
import type.MovieRatingType;

public class MovieReservation {
	private HashMap<String, String> bookers; // 영화번호, 예약자 코드
	private ArrayList<Movie> movies; // 영화 리스트	
	
	public void movieRegister() { // 영화 등록
		/* 제목, 장르, 등급 */
		Movie movie1 = new Movie("US0001", "알라딘", MovieGenreType.ADVENTURE, MovieRatingType.ALL); // 알라딘
		Movie movie2 = new Movie("US0002", "토이 스토리 4",MovieGenreType.ADVENTURE, MovieRatingType.ALL); // 토이스토리 4
		Movie movie3 = new Movie("KR0001", "기생충", MovieGenreType.DRAMA, MovieRatingType.FIFEEN); // 기생충
		Movie movie4 = new Movie("KR0002", "롱 리브 더 킹 : 목포 영웅",MovieGenreType.ACTION, MovieRatingType.FIFEEN); // 롱 리브 더 킹 : 목포 영웅
		
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);		
	}
	
	public HashMap<String, String> getBookers() {
		return bookers;
	}

	public void setBookers(HashMap<String, String> bookers) {
		this.bookers = bookers;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
}
