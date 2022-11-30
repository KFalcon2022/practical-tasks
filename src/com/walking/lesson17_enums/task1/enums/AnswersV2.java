package com.walking.lesson17_enums.task1.enums;

public enum AnswersV2 {
	HELLO("Hello", "Hi"), GOOD_BY("Good bye", "Bye"), HOW_ARE_YOU_DOING("How are your doing","How are you"), DEFAULT("Unknown message","");
	private final String answer;
	private final String question;
	
	AnswersV2(String answer, String question) {
		this.answer = answer;
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public String getQuestion() {
		return question;
	}
}
