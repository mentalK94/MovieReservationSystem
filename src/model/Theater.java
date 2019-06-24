// 영화관 클래스 입니다(영화관에 영화 모델할당)
// 기능 1. 영화예매시 예약자 추가
// 기능 2. 예매취소시 예약자 삭제
// 기능 3. 전체좌석 출력 □■으로 구분	
// 기능 4. 개인좌석 출력(예약자 코드)

package model;

import java.util.ArrayList;

import type.SeatType;

public class Theater {
	
	/* S석은 1열에 10석 보유 */
	public static final int S_ROW_SEAT = 1;
	public static final int S_COLUMN_SEAT = 10;

	/* A석은 4열에 10석 보유 */
	public static final int A_ROW_SEAT = 4;
	public static final int A_COLUMN_SEAT = 10;

	/* B석은 5열에 10석 보유 */
	public static final int B_ROW_SEAT = 5;
	public static final int B_COLUMN_SEAT = 10;

	private Movie movie; // 해당 영화 한가지
	private ArrayList<Booker> bookers; // 예약자	
	private String[][] sSeats; // s좌석
	private String[][] aSeats; // a좌석
	private String[][] bSeats; // b좌석
	
	public Theater(Movie movie) {
		super();
		this.movie = movie;		
		
		sSeats = new String[S_ROW_SEAT][S_COLUMN_SEAT];  // 1 x 10 좌석 할당
		aSeats = new String[A_ROW_SEAT][A_COLUMN_SEAT];  // 4 x 10 좌석 할당
		bSeats = new String[B_ROW_SEAT][B_COLUMN_SEAT];  // 5 x 10 좌석 할당
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ArrayList<Booker> getBookers() {
		return bookers;
	}

	public void setBookers(ArrayList<Booker> bookers) {
		this.bookers = bookers;
	}

	public void setSeat(String bookerName, SeatType seatType, int row, int column) {
		
		switch (seatType) {
		case S: {
			this.sSeats[row][column] = bookerName;
			break;
		}
		case A: {
			this.aSeats[row][column] = bookerName;
			break;
		}
		case B: {
			this.bSeats[row][column] = bookerName;
			break;
		}
		default: {
			break;
		}
		}
	}
	
	public boolean isSseatEmpty(int row, int column) {
		if(this.sSeats[row][column] == null) return true; // 좌석이 빈 경우
		else return false;
	}
	
	public boolean isAseatEmpty(int row, int column) {
		if(this.aSeats[row][column] == null) return true; // 좌석이 빈 경우
		else return false;
	}
	
	public boolean isBseatEmpty(int row, int column) {
		if(this.bSeats[row][column] == null) return true; // 좌석이 빈 경우
		else return false;
	}
	
	public Booker getBookerFromCode(String code) {
		if(bookers.size() == 0) { // 예약자가 한명도 없는 경우
			return null;
		}
		for(int i=0; i<bookers.size(); i++) {
			if(bookers.get(i).getBookNumber().equals(code)) {
				return bookers.get(i);
			}
		}
		
		return null;
	}
	
	public void addBooker(Booker booker) { // 예매자 추가
		bookers.add(booker);
	}
}
