package com.walking.lesson17_enum.task1;

public enum Message {
    HI("Hi", "Hello"){
    },
    BYE("Bye", "Good bye"){
    },
    HOW_ARE_YOU("How are you", "How are you doing"){
    },
    DEFAULT("", "Unknown message"){
    };

    public final String inputMessage;
    public final String outputMessage;

    Message(String inputMessage, String outputMessage) {
        this.inputMessage = inputMessage;
        this.outputMessage= outputMessage;
    }

    public static Message getName(String inputMessage){
        for (Message m : Message.values()) {
            if (m.inputMessage.equals(inputMessage)) {
                return m;
            }
        }
        return DEFAULT;
    }
}
