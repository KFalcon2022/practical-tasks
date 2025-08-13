package com.walking.lesson17_enum.task1.model;

public enum Phrases {
    HI("Hi","Hello"),
    BUY("Bye","Good Bye"),
    HOW_ARE_YOU("How are you","How are you doing"),
    UNKNOWN_MESSAGE("Unknown message");

    private String request;
    private String answer;

    Phrases(String request, String answer) {
        this.request = request;
        this.answer = answer;
    }
    Phrases(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getRequest() {
        return request;
    }

    public static Phrases searchRequest(String request) {

        Phrases[] phrases = Phrases.values();

        for (Phrases phrase : phrases) {
            if (request.equals(phrase.getRequest())) {
                return phrase;
            }
        }

        return UNKNOWN_MESSAGE;
    }
}
