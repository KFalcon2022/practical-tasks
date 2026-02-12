package com.walking.lesson17_enum.task1;

public enum Answer {
    HI("Hi", "Hello"),
    BYE("Bye", "Good bye"),
    HOW("How are you", "How are your doing"),
    UNKNOWN(null, "Unknown message");

    private final String question;
    private final String answer;

    Answer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public static String searchAnswer(String s) {
        if (s == null) {
            return UNKNOWN.answer;
        }

        for (Answer answer : Answer.values()) {
            if (s.equals(answer.getQuestion())) {
                return answer.getAnswer();
            }
        }
        return UNKNOWN.answer;

    }

}
