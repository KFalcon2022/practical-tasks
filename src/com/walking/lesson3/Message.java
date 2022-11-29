package com.walking.lesson3;

public enum Message {
    HELLO("Hi", "Hello"),
    GOODBYE("Bye", "Goodbye"),
    HOW_ARE_YOU("How are you", "How are you doing");

    private String userPhrase;
    private String answer;

    Message(String userPhrase, String answer) {
        this.userPhrase = userPhrase;
        this.answer = answer;
    }

    static String getEnum(String phrase) {
        Message message = null;
        for (Message value : values()) {
            if (value.userPhrase.equals(phrase)) {
                message = value;
            }
        }
        return message == null ? "Unknown message" : message.answer;
    }
}
