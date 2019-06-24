// test용 main

package test;

import app.MovieReservationApp;
import generator.BookCodeGenerator;
import model.Menu;
import model.Message;

public class TestMain {

	public static void main(String[] args) {
		/* BookNumberGenerator Test 완료 */
//		BookNumberGenerator generator = new BookNumberGenerator();
//		String number = generator.getBookNumber();
//		
//		System.out.println(number);
		
		/* Menu Show Test 완료*/
		//Menu.showMenu();

		/* 배열 초기화 x시 null값 할당 테스트 확인 */
//		String [] p = new String[10];
//		for(int i=0; i<p.length; i++) {
//			System.out.println(p[i]);
//		}
		
		/* app test */
		MovieReservationApp app = new MovieReservationApp();
		app.init();
		app.run();
	}

}
