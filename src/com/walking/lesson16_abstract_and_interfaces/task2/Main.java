package com.walking.lesson16_abstract_and_interfaces.task2;

import com.walking.lesson16_abstract_and_interfaces.task2.interfaces.*;
import com.walking.lesson16_abstract_and_interfaces.task2.interfaces.impl.DefaultAnswer;
import com.walking.lesson16_abstract_and_interfaces.task2.interfaces.impl.GoodBye;
import com.walking.lesson16_abstract_and_interfaces.task2.interfaces.impl.HowAreYouDoing;
import com.walking.lesson16_abstract_and_interfaces.task2.interfaces.impl.SayHello;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter string: ");
		String s = scanner.nextLine();
		
		scanner.close();
		
		Answer answer;
		switch (s) {
			case "Hi":
				answer = new SayHello();
				break;
			
			case "Bye":
				answer = new GoodBye();
				break;
			
			case "How are you":
				answer = new HowAreYouDoing();
				break;
			
			default:
				answer = new DefaultAnswer();
		}
		
//		Answer answer = switch (s) {
//			case "Hi" -> new SayHello();
//			case "Bye" -> new GoodBye();
//			case "How are you" -> new HowAreYouDoing();
//			default -> new DefaultAnswer();
//		};
		
		answer.say();
	}
}
