// 예약자는 최대 4명까지 예약할 수 있다

package model;

import type.SeatType;

public class Booker {
	private String name; // 예약자 이름
	private SeatType seatType[]; // 예약자 좌석 타입
	private Integer seatNumber[]; // 예약자 좌석 번호
	private String bookNumber; // 예약번호
	private int numberOfBookers; // 예약 명 수

	public Booker(int number) { 
		this.numberOfBookers = number;
		this.seatNumber = new Integer[number];
		this.seatType = new SeatType[number];
	}
	
	public int getNumberOfBookers() {
		return numberOfBookers;
	}

	public void setNumberOfBookers(int numberOfBookers) {
		this.numberOfBookers = numberOfBookers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSeatType(int index, SeatType seatType) {
		this.seatType[index] = seatType;
	}
	
	public SeatType getSeatType(int index) {
		return this.seatType[index];
	}
	
	public void setSeatNumber(int index, int seatNumber) {
		this.seatNumber[index] = seatNumber;
	}
	
	public int getSeatNumber(int index) {
		return this.seatNumber[index];
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
	
	public Booker getBookerFromBookNumber(String bookNumber) {
		return this;
	}
}
