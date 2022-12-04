package com.walking.lesson17_enum.task1.answer;

public enum Answer {
    HI("Hi", "Hello"), BYE("Bye", "Good bye"), HOW_ARE_YOU("How are you", "How are your doing");
    public final String answer;
    public final String question;
    Answer(String question, String answer) {
        this.answer = answer;
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public String getQuestion(){
        return question;
    }


}
