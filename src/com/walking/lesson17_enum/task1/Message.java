package com.walking.lesson17_enum.task1;

public enum Message {
    HELLOMESSAGE("Hi", "Hello!"),
    BYEMESSAGE("Bye", "Good bye!"),
    ASKMESSAGE("How are you", "How are your doing?"),
    UNKNOWNMESSAGE("", "Unknown message");

    private String userMessage;
    private String requiredMessage;

    Message(String userMessage, String requiredMessage) {
        this.userMessage = userMessage;
        this.requiredMessage = requiredMessage;
    }

    public String getRequiredMessage() {
        return requiredMessage;
    }

    public static Message findMessage(String s) {
        for (Message message : Message.values()) {
            if (message.userMessage.equals(s)) {
                return message;
            }
        }
        return UNKNOWNMESSAGE;
    }
}

