package com.walking.lesson17_enums.task1.enums;

public enum Answers {
	HI, BYE, HOW_ARE_YOU;
	private static final String HELLO = "Hello";
	private static final String GOOD_BY = "Good bye";
	private static final String HOW_ARE_YOU_DOING = "How are your doing";
	private static final String DEFAULT = "How are your doing";
	
	public static void getAnswer(String question) {
		switch (Answers.valueOf(question)) { //отхватим ексепшен, еслинет совпадения з названием enum'а...Плохой вариант.
			case HI -> System.out.println(HELLO);
			case BYE -> System.out.println(GOOD_BY);
			case HOW_ARE_YOU -> System.out.println(HOW_ARE_YOU_DOING);
			default -> System.out.println(DEFAULT);
		}
	}
}
