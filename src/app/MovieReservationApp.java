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
import model.MovieReservation;
import type.MenuType;
import type.MessageType;
import type.MovieGenreType;
import type.MovieRatingType;

public class MovieReservationApp {
	
	private MenuType choiceMenu; // 메뉴 선택
	private int choiceNumber;
	private Scanner scanner; // 입력받기위한 Scanner 클래스
	private MovieReservation movieReservation;
	
	public void init() { // 기본 세팅
		
		scanner = new Scanner(System.in);
		movieReservation = new MovieReservation();
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
		String movieCode = selectMovie();
		if(movieCode == null) {
			Message.showMessage(MessageType.ERROR);
			return;
		}
		
		// 2. 예매자 수 입력
		int number = inputNumber();
		if(number == -1) {
			Message.showMessage(MessageType.ERROR);
			return;
		}
		
		// 3. 좌석 타입 선택
		// 4. 좌석 타입에 맞는 현황 출력
		// 5. 좌석 번호 선택
		// 6. 예매자 입력
		// 7. 예매 완료 출력
	}

	public String selectMovie() { // 영화 선택 기능 구현
		ArrayList<Movie> movies = movieReservation.getMovies();
		
		int selectMovieIndex = -1; // 선택한 영화 인덱스 번호
		Message.showMessage(MessageType.MOVIELIST);
		Message.showFromString("\n");
		for(int i=0; i<movies.size(); i++) {
			Message.showFromString("[" + i + "]");
			movies.get(i).showMovieFromOrder();
		}
		
		Message.showInputMessage(MessageType.SELECTMOVIE);
		selectMovieIndex = scanner.nextInt(); // 영화 인덱스 입력
		
		if(selectMovieIndex >= 0 && selectMovieIndex < movies.size())
			return movies.get(selectMovieIndex).getCode(); // 선택한 영화 코드 리턴
		else return null; // 제대로 선택하지 않은 경우
	}
	
	public int inputNumber() {
		Message.showInputMessage(MessageType.INPUTRESERVATIONNUMBER); // 예약 인원 수 입력
		int number = scanner.nextInt();
		if(number >= 1 && number <= 4)
			return number;
		else return -1;
	}
	

}
