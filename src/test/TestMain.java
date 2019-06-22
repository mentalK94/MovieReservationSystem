// test용 main

package test;

import generator.BookNumberGenerator;

public class TestMain {

	public static void main(String[] args) {
		BookNumberGenerator generator = new BookNumberGenerator();
		String number = generator.getBookNumber();
		
		System.out.println(number);
		
	}

}
