package com.walking.lesson16_abstract_class_interface.task22.talk;

public class Bye implements Phrase {

    private final String bye = "Bye";

    @Override
    public String getPhrase() {
        return bye;
    }
}
