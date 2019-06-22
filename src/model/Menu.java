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

	public static MenuType choiceMenu(int choice) { // 숫자 -> enum타입

		switch (choice) {
			case 1: {
				return MenuType.RESERVATION;
			}
			case 2: {
				return MenuType.SHOWALL;
			}
			case 3: {
				return MenuType.SHOWINDIVIDUAL;
			}
			case 4: {
				return MenuType.CANCEL;
			}
			case 5: {
				return MenuType.EXIT;
			}
			default: {
				return null;
			}
		}
	}
}
