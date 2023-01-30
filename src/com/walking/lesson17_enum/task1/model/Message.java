package com.walking.lesson17_enum.task1.model;

public enum Message {
    HI("Hi", "Hello"),
    BYE("Bye", "Good bye"),
    HOW_ARE_YOU("How are you", "How are your doing"),
    UNKNOWN(null, "Unknown message");

    private String greeting;
    private String answer;

    Message(String greeting, String answer) {
        this.greeting = greeting;
        this.answer = answer;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getAnswer() {
        return answer;
    }

    public static Message findMessage(String message)
    {
        if (message == null) {
            return UNKNOWN;
        }

        for (Message msg : Message.values()) {
            if (message.equals(msg.greeting)) {
                return msg;
            }
        }
        return UNKNOWN;
    }
}
