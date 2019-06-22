package model;

import type.MessageType;

public class Message {	
	
	public static void showMessage(MessageType messageType) {
		System.out.println(messageType.getMessage());
	}
	
	public static void showInputMessage(MessageType messageType) {
		System.out.print(messageType.getMessage());
	}
	
	public static void showFromString(String message) {
		System.out.println(message);
	}
}
