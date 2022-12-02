package com.walking.lesson16_abstract_class_interface.task2.talk;

public class PhraseDispatcher implements Phrase {

    @Override
    public String getPhrase(String s) {
        switch (s) {
            case Phrase.hi:
                return "Hi";

            case Phrase.bye:
                return "Bye";

            case Phrase.how:
                return "How are you doing";

            default:
                return Phrase.unknown;
        }
    }
}
