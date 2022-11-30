package com.walking.lesson17_enums.task1;

import java.util.Scanner;

import static com.walking.lesson17_enums.task1.enums.AnswersV2.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = scanner.nextLine();
		
		scanner.close();

//		Answers.getAnswer(s);
		getAnswer(s);
	}
	
	public static void getAnswer(String question) {
		if (HELLO.getQuestion().equals(question)) {
			System.out.println(HELLO.getAnswer());
		} else if (GOOD_BY.getQuestion().equals(question)) {
			System.out.println(GOOD_BY.getAnswer());
		} else if (HOW_ARE_YOU_DOING.getQuestion().equals(question)) {
			System.out.println(HOW_ARE_YOU_DOING.getAnswer());
		}
	}
}
