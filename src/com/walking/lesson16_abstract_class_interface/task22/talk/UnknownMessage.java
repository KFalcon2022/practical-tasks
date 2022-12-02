package com.walking.lesson16_abstract_class_interface.task22.talk;

public class UnknownMessage implements Phrase {

    private final String unknown = "Unknown message";

    @Override
    public String getPhrase() {
        return unknown;
    }

}
