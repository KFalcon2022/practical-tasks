package com.walking.lesson17_enum.task1.answer;

public enum Report {
    HI("Hello", "Hi"),
    HOW_ARE_YOU("How are you  doing?", "How are you"),
    BYE("Good bye", "Bye"),
    UNKNOWN_GREETING("Unknown phrase", "some question");

    private final String answer;
    private final String message;

    Report(String answer, String message) {
        this.answer = answer;
        this.message = message;
    }

    public String getAnswer() {
        return answer;
    }

    public String getMessage() {
        return message;
    }

    public static String toAnswer(String question) {
        for (Report x : values()) {
            if (question.equals(x.getMessage())) {
                return x.getAnswer();
            }
        }
        return UNKNOWN_GREETING.getAnswer();
    }
}
