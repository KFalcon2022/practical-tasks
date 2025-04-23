package com.walking.lesson17_enum.task1.answer;

public enum Answer {
    HI("Hello", "Hi"),
    HOW_ARE_YOU("How are you  doing?", "How are you"),
    BYE("Good bye", "Bye"),
    UNKNOWN_GREETING("Unknown phrase", "some question");

    private final String answer;
    private final String question;

    Answer(String answer, String question) {
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public static String comparePhrase(String question, Answer[] answers) {
        for (Answer x : answers) {
            if (question.equals(x.getQuestion())) {
                return x.getAnswer();
            }
        }
        return UNKNOWN_GREETING.getAnswer();
    }
}
