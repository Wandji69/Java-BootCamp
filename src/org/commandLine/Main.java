package org.commandLine;

import java.util.Scanner;

public class Main {
	
	static final int AMOUNT = 10000;
	static Scanner scanner = new Scanner(System.in);
	static String[] memberNames = new String[10];
	static int[] memberAges = new int[10];
	static double[] memberAmounts = new double[10];
	static int lastIndex = 0;
	
	public static void main(String[] args) {
		
		String option;
		do {
			menu();
			option = scanner.nextLine();
			if (option.equals("A")) {
				register();
			} else if (option.equals("B")) {
				listAll();
			} else {
				System.out.print("Invalid Option");
			}
		} while (!option.equals("Q"));
	}
	
	/**
	 * Menu function
	 */
	static void menu() {
		System.out.println("Please enter of an option below:");
		System.out.println("Q: End program");
		System.out.println("A: Register a User");
		System.out.println("B: List all Users");
		System.out.print("Option: ");
	}
	
	/**
	 * Register User Function
	 */
	static void register() {
		System.out.println("Enter a user's name:");
		String name = scanner.nextLine();
		System.out.println("Enter a user's age:");
		int age = scanner.nextInt();
		scanner.nextLine();
		
		if (age < 13) {
			System.out.println("Too young to be a member");
			return;
		} else if (age > 50) {
			memberAmounts[lastIndex] = discount(AMOUNT);
		} else {
			memberAmounts[lastIndex] = AMOUNT;
		}
		memberNames[lastIndex] = name;
		memberAges[lastIndex] = age;
		lastIndex++;
	}
	
	/**
	 * List all registered members
	 */
	static void listAll() {
		System.out.println("Members list:");
		for (int i = 0; i < 10; i++) {
			if (memberNames != null) {
				System.out.println("Name: " + memberNames[i] + " --- " + "Amount: " + memberAmounts[i]);
			}
		}
	}
	
	private static double discount(int amount) {
		// 10 percent discount
		return amount - (amount * 0.1);
	}
	
}
