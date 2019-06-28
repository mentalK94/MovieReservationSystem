package impl;

import java.util.ArrayList;

import model.Booker;
import model.Message;
import model.Movie;
import model.Theater;
import type.MessageType;
import type.SeatType;

public class TheaterManagerImpl {

	private ArrayList<Theater> theaters;
	private MovieList movies;

	public void init() {
		movies = new MovieList(); 
		movies.movieRegister(); // 영화 리스트 등록
		theaters = new ArrayList<Theater>();

		/* 등록된 리스트를 가지고 theater 생성 -> theaters에 추가 */
		for (int i = 0; i < movies.getMovies().size(); i++) {
			Theater theater = new Theater(movies.getMovies().get(i));
			theaters.add(theater);
		}
	}

	public ArrayList<Movie> getMovies() {
		return movies.getMovies();
	}

	public void setMovies(MovieList movies) {
		this.movies = movies;
	}

	public ArrayList<Theater> getTheaters() {
		return theaters;
	}

	public void setTheaters(ArrayList<Theater> theaters) {
		this.theaters = theaters;
	}

	// 영화 전체 좌석 조회 기능 구현
	public void showAll(String movieCode) {
		
		int movieIndex = -1;
		for(int i=0; i<theaters.size(); i++) {
			if(theaters.get(i).getMovie().getCode().equals(movieCode))
				movieIndex = i;
		}

		if(movieIndex == -1) {
			Message.showMessage(MessageType.ERROR);
			return;
		}
		
		// "" 영화 조회입니다 메시지 출력
		String movieTitle = theaters.get(movieIndex).getMovie().getTitle();
		Message.showFromString("[제" + (movieIndex + 1) + "영화관] " + movieTitle + " 좌석 현황입니다");

		Message.showFromString2("S석 : ");
		for (int i = 0; i < Theater.S_ROW_SEAT; i++) {
			for (int j = 0; j < Theater.S_COLUMN_SEAT; j++) {
				if (theaters.get(movieIndex).isSseatEmpty(i, j)) // 좌석이 빈경우
					Message.showFromString2(SeatType.EMPTY.getName());
				else
					Message.showFromString2(SeatType.SEATED.getName()); // 좌석이 찬 경우				
			}
			Message.showFromString("");
			Message.showFromString2("     ");
		}

		Message.showFromString("");

		Message.showFromString2("A석 : ");
		for (int i = 0; i < Theater.A_ROW_SEAT; i++) {
			for (int j = 0; j < Theater.A_COLUMN_SEAT; j++) {
				if (theaters.get(movieIndex).isAseatEmpty(i, j)) // 좌석이 빈경우
					Message.showFromString2(SeatType.EMPTY.getName());
				else
					Message.showFromString2(SeatType.SEATED.getName()); // 좌석이 찬 경우				
			}
			Message.showFromString("");
			Message.showFromString2("     ");
		}

		Message.showFromString("");
		
		Message.showFromString2("B석 : ");
		for (int i = 0; i < Theater.B_ROW_SEAT; i++) {
			for (int j = 0; j < Theater.B_COLUMN_SEAT; j++) {
				if (theaters.get(movieIndex).isBseatEmpty(i, j)) // 좌석이 빈경우
					Message.showFromString2(SeatType.EMPTY.getName());
				else
					Message.showFromString2(SeatType.SEATED.getName()); // 좌석이 찬 경우
			}
			Message.showFromString("");
			Message.showFromString2("     ");
		}

	}

	// // 영화 개인 좌석 조회 기능 구현(추후 구현)
	// public void showIndividual(int movieIndex, String bookerCode) {
	//
	// // "○○○"님 영화 예매 현황입니다
	// Booker booker = theaters.get(movieIndex).getBookerFromCode(bookerCode); //
	// booker 객체 찾기
	// Message.showFromString(booker.getName() + "님 영화 예매 현황입니다");
	//
	// for(int i=0; i<Theater.S_ROW_SEAT; i++) {
	// for(int j=0; j<Theater.S_COLUMN_SEAT; j++) {
	// if(theaters.get(movieIndex).isSseatEmpty(i, j)) // 좌석이 빈경우
	// Message.showFromString2(SeatType.EMPTY.getName());
	// else Message.showFromString2(SeatType.SEATED.getName()); // 좌석이 찬 경우
	// }
	// }
	//
	// Message.showFromString("");
	//
	// for(int i=0; i<Theater.A_ROW_SEAT; i++) {
	// for(int j=0; j<Theater.A_COLUMN_SEAT; j++) {
	// if(theaters.get(movieIndex).isAseatEmpty(i, j)) // 좌석이 빈경우
	// Message.showFromString2(SeatType.EMPTY.getName());
	// else Message.showFromString2(SeatType.SEATED.getName()); // 좌석이 찬 경우
	// }
	// }
	//
	// Message.showFromString("");
	//
	// for(int i=0; i<Theater.B_ROW_SEAT; i++) {
	// for(int j=0; j<Theater.B_COLUMN_SEAT; j++) {
	// if(theaters.get(movieIndex).isBseatEmpty(i, j)) // 좌석이 빈경우
	// Message.showFromString2(SeatType.EMPTY.getName());
	// else Message.showFromString2(SeatType.SEATED.getName()); // 좌석이 찬 경우
	// }
	// }
	//
	// }

	// 영화 예매 기능 구현
	public void reservation(String movieCode, Booker booker) {

		int numOfBooker = booker.getNumberOfBookers(); // 예매자 수
		int movieIndex = -1;
		for(int i=0; i<theaters.size(); i++) {
			if(theaters.get(i).getMovie().getCode().equals(movieCode)) {
				movieIndex = i;
			}
		}
		
		for (int i = 0; i < numOfBooker; i++) {
			SeatType sType = booker.getSeatType(i); // 좌석 타입
			
			int row = ((booker.getSeatNumber(i)-1) / 10); // 좌석 열 번호
			int column = ((booker.getSeatNumber(i)-1) % 10); // 좌석 행 번호

			switch (sType) {
			case S: {
				if (theaters.get(movieIndex).isSseatEmpty(row, column)) { // 빈 자리인 경우 : booker를 Theater리스트에 추가, 좌석현황 변경
					theaters.get(movieIndex).addBooker(booker);
					theaters.get(movieIndex).setSeat(booker.getName(), sType, row, column);
				} else { // 좌석이 이미 있는 경우
					Message.showMessage(MessageType.ALREADYSEATS);
					return;
				}
				break;
			}
			case A: {
				if (theaters.get(movieIndex).isAseatEmpty(row, column)) { // 빈 자리인 경우 : booker를 Theater리스트에 추가, 좌석현황 변경		
					theaters.get(movieIndex).addBooker(booker);
					theaters.get(movieIndex).setSeat(booker.getName(), sType, row, column);
				} else { // 좌석이 이미 있는 경우		
					Message.showMessage(MessageType.ALREADYSEATS);
					return;
				}
				break;
			}
			case B: {
				if (theaters.get(movieIndex).isBseatEmpty(row, column)) { // 빈 자리인 경우 : booker를 Theater리스트에 추가, 좌석현황 변경
					theaters.get(movieIndex).addBooker(booker);
					theaters.get(movieIndex).setSeat(booker.getName(), sType, row, column);					
				} else { // 좌석이 이미 있는 경우	
					Message.showMessage(MessageType.ALREADYSEATS);
					return;
				}
				break;
			}
			default: {
				break;
			}
			}
		}
	}

	// 영화 취소 기능 구현
}
