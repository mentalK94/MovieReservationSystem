package model;

import type.MenuType;

public class Menu {

	public static void showMenu() { // 메뉴 출력
		
		int index = 1;
		
		System.out.println("◇◇◇◇◇◇◇◇");
		for (MenuType menutype : MenuType.values()) {
			System.out.println(index + ". " + menutype.getName());
			index++;
		}
		System.out.println("◇◇◇◇◇◇◇◇");
	}
}
