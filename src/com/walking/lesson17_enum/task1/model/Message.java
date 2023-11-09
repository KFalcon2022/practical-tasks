package com.walking.lesson17_enum.task1.model;

public enum Message {
    Hello("Hi", "Hello"),
    GoodBye("Bye", "Good bye"),
    HowAreYou("How are you", "How are you doing"),
    UnknownMessage(null, "Unknown message");

    private final String message;
    private final String answer;

    Message(String message, String answer) {
        this.message = message;
        this.answer = answer;
    }

    public static Message findAnswer(String messageUser) {
        for (Message message : Message.values()) {
            if (messageUser.equals(message.message)) {
                return message;
            }
        }
        return UnknownMessage;
    }

    public String getAnswer() {
        return answer;
    }
}
