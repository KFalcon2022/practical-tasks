package com.walking.lesson17_enum.task1.model;

public enum Answer {
    HI("Hi", "Hello"),
    GOODBYE("Bye", "Good bye"),
    HOW_ARE_YOU("How are you", "How are you doing"),
    UNKNOWN(null, "Unknown message");

    private final String output;
    private final String input;

    private Answer(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public String getAnswer() {
        return getOutput();
    }

    public static Answer findAnswer(String input) {
        if(input == null) {
            return UNKNOWN;
        }

        for (Answer answer : Answer.values()) {
            if(input.equals(answer.getInput())) {
                return answer;
            }
        }

        return UNKNOWN;
    }
}
