// 예약자는 예약번호와 함께 해시맵으로 가지고 있는다
// 영화는 리스트로 구현하여 가지고 있는다
// 영화 리스트는 파일입출력 사용하여 텍스트로 가져온다(파일입출력 배우고 나서 구현)

package app;

import java.util.ArrayList;
import java.util.Scanner;

import generator.BookCodeGenerator;
import impl.TheaterManagerImpl;
import model.Booker;
import model.Menu;
import model.Message;
import model.Movie;
import model.Theater;
import type.MenuType;
import type.MessageType;
import type.SeatType;

public class MovieReservationApp {

	private Scanner scanner; // 입력받기위한 Scanner 클래스
	private TheaterManagerImpl theaterManager;
	private BookCodeGenerator bookCodeGenerator;

	public void init() { // 기본 세팅

		theaterManager = new TheaterManagerImpl();
		theaterManager.init();
	}

	public void run() { // 앱 실행

		scanner = new Scanner(System.in);
		// 0. 프로그램 실행 메시지
		Message.showMessage(MessageType.RUN);

		// 1. 메뉴 출력
		Menu.showMenu();

		// 2. 메뉴 선택
		int choiceNumber = scanner.nextInt();
		MenuType choiceMenu = Menu.choiceMenu(choiceNumber);

		if (choiceMenu != null) {
			switch (choiceMenu) {
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
			Message.showMessage(MessageType.ERROR); // 입력 에러 메시지
			return;
		}

	}

	public void cancel() { // 예매 취소기능 구현

	}

	public void showSeatsIndividual() { // 개인좌석 조회 기능 구현

	}

	public void showSeatsAll() { // 전체좌석 조회 기능 구현
		Message.showMessage(MessageType.SELECTMOVIE);
		int selectMovie = scanner.nextInt();
		if (selectMovie >= 1 && selectMovie <= theaterManager.getMovies().size()) { // 영화선택 제대로 입력했는지 검사
			String movieCode = theaterManager.getMovies().get(selectMovie-1).getCode();
			theaterManager.showAll(movieCode); // showAll 호출
			Message.showMessage(MessageType.SUCCEEDSHOW);
		}
		else {
 			Message.showMessage(MessageType.FAILSHOW);
		}
	}

	public void reservation() { // 예약 기능 구현

		Booker booker;
		
		// 1. 영화 선택
		String movieCode = selectMovie();
		if (movieCode == null) {
			Message.showMessage(MessageType.ERROR);
			return;
		}
		
		// 2. 좌석 현황 출력
		theaterManager.showAll(movieCode);

		// 3. 예매자 수 입력
		int number = inputNumber();
		if (!(number > 0 && number < 5)) {
			Message.showMessage(MessageType.ERROR);
			return;
		} else {
			booker = new Booker(number);
		}

		for(int i=0; i<number; i++) {
			// 4. 좌석 타입 선택
			Message.showInputMessage(MessageType.SELECTSEATTYPE);
			int seatTypeNumber = scanner.nextInt();
			SeatType seatType;
			if (seatTypeNumber == 1) {
				seatType = SeatType.S;
			} else if (seatTypeNumber == 2) {
				seatType = SeatType.A;
			} else if (seatTypeNumber == 3) {
				seatType = SeatType.B;
			} else {
				Message.showMessage(MessageType.ERROR);
				return;
			}

			// 5. 좌석 번호 선택
			Message.showInputMessage(MessageType.SELECTSEATNUMBER);
			int seatNumber = scanner.nextInt();
			// 5-1. 좌석 번호 검사
			if(seatType.equals(SeatType.S)) {
				if(!(seatNumber > 0 && seatNumber <= (Theater.S_ROW_SEAT * Theater.S_COLUMN_SEAT))) {
					Message.showMessage(MessageType.ERROR);
					return;
				} 				
			} else if(seatType.equals(SeatType.A)) {
				if(!(seatNumber > 0 && seatNumber <= (Theater.A_ROW_SEAT * Theater.A_COLUMN_SEAT))) {
					Message.showMessage(MessageType.ERROR);
					return;
				} 			
			} else {
				if(!(seatNumber > 0 && seatNumber <= (Theater.B_ROW_SEAT * Theater.B_COLUMN_SEAT))) {
					Message.showMessage(MessageType.ERROR);
					return;
				} 			
			}
			
			booker.setSeatType(i, seatType);
			booker.setSeatNumber(i, seatNumber);
		}

		scanner.nextLine();
		// 6. 예매자 성명 입력
		Message.showInputMessage(MessageType.INPUTNAME);
		String name = scanner.nextLine();
		booker.setName(name);
		
		// 7. 예매번호 할당
		bookCodeGenerator = new BookCodeGenerator();
		booker.setBookNumber(bookCodeGenerator.getBookNumber());

		theaterManager.reservation(movieCode, booker);
		// 7. 예매 완료 출력
		Message.showMessage(MessageType.SUCCEEDRESERVATION);
	}

	public String selectMovie() { // 영화 선택 기능 구현
		ArrayList<Movie> movies = theaterManager.getMovies();

		int selectMovieIndex = -1; // 선택한 영화 인덱스 번호
		Message.showMessage(MessageType.MOVIELIST);
		Message.showFromString("\n");
		for (int i = 0; i < movies.size(); i++) {
			Message.showFromString("[" + i + "]");
			movies.get(i).showMovieFromOrder();
		}

		Message.showInputMessage(MessageType.SELECTMOVIE);
		selectMovieIndex = scanner.nextInt(); // 영화 인덱스 입력

		if (selectMovieIndex >= 0 && selectMovieIndex < movies.size())
			return movies.get(selectMovieIndex).getCode(); // 선택한 영화 코드 리턴
		else
			return null; // 제대로 선택하지 않은 경우
	}

	public int inputNumber() {
		Message.showInputMessage(MessageType.INPUTRESERVATIONNUMBER); // 예약 인원 수 입력
		int number = scanner.nextInt();
		if (number >= 1 && number <= 4)
			return number;
		else
			return -1;
	}

}
