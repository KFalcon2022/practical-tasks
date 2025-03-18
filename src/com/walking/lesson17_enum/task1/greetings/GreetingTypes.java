package com.walking.lesson17_enum.task1.greetings;

public enum GreetingTypes {

    HELLO("Hello"), GOODBYE("Goodbye"), HOW("How are you"), UNKNOWN("Unknown message");
    final String greeting;

    GreetingTypes(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
