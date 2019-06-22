// 예약자는 예약번호와 함께 해시맵으로 가지고 있는다
// 영화는 리스트로 구현하여 가지고 있는다
// 영화 리스트는 파일입출력 사용하여 텍스트로 가져온다(파일입출력 배우고 나서 구현)

package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.Menu;
import model.Message;
import model.Movie;
import type.MenuType;
import type.MessageType;
import type.MovieGenreType;
import type.MovieRatingType;

public class MovieReservationApp {
	private HashMap<String, String> bookers; // 영화번호, 예약자 코드
	private ArrayList<Movie> movies; // 영화 리스트	
	private MenuType choiceMenu; // 메뉴 선택
	private int choiceNumber;
	private Scanner scanner; // 입력받기위한 Scanner 클래스
	
	public void init() { // 기본 세팅
		
		scanner = new Scanner(System.in);
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

	public void run() { // 앱 실행
		// 0. 프로그램 실행 메시지
		Message.showMessage(MessageType.RUN);
		
		// 1. 메뉴 출력
		Menu.showMenu();
		
		// 2. 메뉴 선택
		choiceNumber = scanner.nextInt();
		choiceMenu = Menu.choiceMenu(choiceNumber);
		
		if(choiceMenu != null) {
			switch(choiceMenu) {
			case RESERVATION: { // 예약 기능
				reservation();
				break;
			}
			case SHOWALL: { // 전체조회 기능
				showSeatsAll();
				break;
			}
			case SHOWINDIVIDUAL: { // 개인조회 기능
				showSeatsIndividual();
				break;
			}
			case CANCEL: { // 예약취소 기능
				cancel();
				break;
			}
			case EXIT: { // 종료 기능
				Message.showMessage(MessageType.EXIT); // 프로그램 종료 메시지
				System.exit(0); // 프로그램 종료
				break;
			}
			}
		} else {
			Message.showMessage(MessageType.ERROR);  // 입력 에러 메시지 
		}
		
	}
	
	public void cancel() { // 예매 취소기능 구현
		
	}

	public void showSeatsIndividual() { // 개인좌석 조회 기능 구현
		
	}

	public void showSeatsAll() { // 전체좌석 조회 기능 구현
		
	}

	public void reservation() { // 예약 기능 구현
		
		// 1. 영화 선택
		// 2. 예매자 수 입력
		// 3. 좌석 타입 선택
		// 4. 좌석 타입에 맞는 현황 출력
		// 5. 좌석 번호 선택
		// 6. 예매자 입력
		// 7. 예매 완료 출력
	}

	public String selectMovie() { // 영화 선택 기능 구현
		
		int selectMovieIndex = -1; // 선택한 영화 인덱스 번호
		Message.showMessage(MessageType.SELECTMOVIE);
		Message.showFromString("\n");
		for(int i=0; i<movies.size(); i++) {
			Message.showFromString("[" + i + "]");
			movies.get(i).showMovieFromOrder();
		}
		
		Message.showMessage(MessageType.SELECTMOVIE);
		selectMovieIndex = scanner.nextInt(); // 영화 인덱스 입력
		
		return movies.get(selectMovieIndex).getCode(); // 선택한 영화 코드 리턴
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
