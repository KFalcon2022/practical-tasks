package com.walking.lesson17_enum.task1.greetings;

public enum GreetingTypes {

    HELLO("Hi", "Hello"),
    GOODBYE("Bye", "Goodbye"),
    HOW("How are you", "How are you doing"),
    UNKNOWN(null, "Unknown message");

    private final String greeting;
    private final String respond;

    GreetingTypes(String greeting, String respond) {
        this.greeting = greeting;
        this.respond = respond;
    }

    public static GreetingTypes findGreetingType(String greeting) {
        if (greeting == null) {
            return UNKNOWN;
        }

        for (GreetingTypes type : GreetingTypes.values()) {
            if (greeting.equals(type.greeting)) {
                return type;
            }
        }
        return UNKNOWN;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getRespond() {
        return respond;
    }
}
