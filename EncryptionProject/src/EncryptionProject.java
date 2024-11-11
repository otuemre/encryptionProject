package EncryptionProject.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EncryptionProject {

	private Scanner scanner;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String message;

	public EncryptionProject() {
		scanner = new Scanner(System.in);
		list = new ArrayList<Character>();
		shuffledList = new ArrayList<Character>();
		character = ' ';

		newKey();
		askQuestion();
	}

	private void askQuestion() {
		while (true) {
			System.out.println("*************************************************");
			System.out.println("What do you want to do?");
			System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrytpt, (Q)uit");

			char response = Character.toUpperCase(scanner.nextLine().charAt(0));

			decision(response);

		}
	}

	private void newKey() {

		character = ' ';
		list.clear();
		shuffledList.clear();

		for (int i = 32; i < 127; i++) {
			list.add(character);
			character++;
		}

		shuffledList = new ArrayList<Character>(list);
		Collections.shuffle(shuffledList);

		System.out.println("* A New Key is Generated! *");
	}

	private void getKey() {

		System.out.println("Key: ");
		for (char c : list) {
			System.out.print(c);
		}

		System.out.println();

		for (char c : shuffledList) {
			System.out.print(c);
		}

		System.out.println();
	}

	private void encrypt() {

		System.out.println("Please, Enter the Message: ");
		message = scanner.nextLine();

		if (message.length() < 1) {
			System.out.println("Error: Please, Type Your Message!");
			encrypt();
		} else {
			System.out.print("Encrypted Message: ");
			for (int i = 0; i < message.length(); i++) {
				int index = list.indexOf(message.charAt(i));
				System.out.print(shuffledList.get(index));
			}

			System.out.println();
		}
	}

	private void decrypt() {

		System.out.println("Please, Enter the Message: ");
		message = scanner.nextLine();

		if (message.length() < 1) {
			System.out.println("Error: Please, Type Your Message!");
			decrypt();
		} else {
			System.out.print("Decrypted Message: ");
			for (int i = 0; i < message.length(); i++) {
				int index = shuffledList.indexOf(message.charAt(i));
				System.out.print(list.get(index));
			}

			System.out.println();
		}
	}

	private void quit() {
		System.out.println("Shhhhhhh! See You Soon :))");
		System.exit(0);
	}

	private void decision(char response) {

		switch (response) {
		case 'N':
			newKey();
			break;
		case 'G':
			getKey();
			break;
		case 'E':
			encrypt();
			break;
		case 'D':
			decrypt();
			break;
		case 'Q':
			quit();
			break;
		default:
			System.out.println("Not a Valid Answer :(");
		}
	}
}
