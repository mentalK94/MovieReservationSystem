/* 예약번호 생성기 클래스 입니다 */
/* 예약번호는 8자리 수이며, 소문자, 대문자, 숫자로 구성 */
package generator;

import java.util.Random;

public class BookNumberGenerator {
	
	private final static int NUMBERDIGITS = 8; // 예약번호 자리수
	private String bookNumber; // 예약번호
	
	public BookNumberGenerator() { // 예약번호 생성
		StringBuffer number = new StringBuffer();
		Random random = new Random();
		
		for(int i=0; i<NUMBERDIGITS; i++) {
			int randomIndex = random.nextInt(3);
			switch (randomIndex) {
			case 0:  // 소문자 생성
				number.append((char) ((int)(random.nextInt(26)) + 97));
				break;
			case 1:  // 대문자 생성
				number.append((char) ((int)(random.nextInt(26)) + 65));
				break;
			case 2: // 0~9숫자 생성
				number.append(random.nextInt(10));
				break;	
			default:
				System.out.println("예약번호 생성오류..");
				break;
			}
		}
		
		this.bookNumber = number.toString();
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
}
