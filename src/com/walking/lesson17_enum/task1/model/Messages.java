package com.walking.lesson17_enum.task1.model;

public enum Messages {
    HI("Hi", "Hello"),
    BYE("Bye", "Good bye"),
    HOW_ARE_YOU("How are you", "How are doing"),
    UNKNOWN(null, "Unknown message");

    private final String message;
    private final String answer;

    Messages(String message, String answer) {
        this.message = message;
        this.answer = answer;
    }

    public String getMessage() {
        return message;
    }

    public static Messages searchValueByMessage(String message) {
        if (message == null) {
            return UNKNOWN;
        }
        for (Messages msg : Messages.values()) {
            if (message.equals(msg.message)) {
                return msg;
            }
        }
        return UNKNOWN;
    }

    public String getAnswer() {
        return answer;
    }
}
