package com.walking.lesson17_enums.task1;

import com.walking.lesson17_enums.task1.enums.AnswersV2;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = scanner.nextLine();
		
		scanner.close();

//		Answers.getAnswer(s);
		AnswersV2.getAnswer(s);
	}
}
