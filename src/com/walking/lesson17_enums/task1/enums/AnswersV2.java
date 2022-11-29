package com.walking.lesson17_enums.task1.enums;

public enum AnswersV2 {
	HELLO("Hello"), GOOD_BY("Good bye"), HOW_ARE_YOU_DOING("How are your doing"), DEFAULT("Unknown message");
	private final String answer;
	private static final String HI = "Hi";
	private static final String BYE = "Bye";
	private static final String HOW_ARE_YOU = "How are you";
	
	AnswersV2(String answer) {
		this.answer = answer;
	}
	
	public static void getAnswer(String question) {
		switch (question) {
			case HI -> System.out.println(HELLO.answer);
			case BYE -> System.out.println(GOOD_BY.answer);
			case HOW_ARE_YOU -> System.out.println(HOW_ARE_YOU_DOING.answer);
			default -> System.out.println(DEFAULT.answer);
		}
	}
}
