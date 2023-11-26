package com.walking.lesson17_enum.task1;

enum Answers{
	HI("Hello!"),
	BYE("Good bye!"),
	HOW_ARE_YOU("How are your doing?"),
	UNKNOWN_INPUT("I don't understand you.");
    private String answer;
    Answers(String answer){
        this.answer = answer;
    }
    public String getAnswer(){
        return answer;
    }

}
