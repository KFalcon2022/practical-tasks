package com.walking.lesson16_abstract_class_interface.task22.talk;

public class How implements Phrase {

    private final String how = "How are you";

    @Override
    public String getPhrase() {
        return how;
    }
}
