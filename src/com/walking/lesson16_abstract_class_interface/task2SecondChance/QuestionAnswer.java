package com.walking.lesson16_abstract_class_interface.task2SecondChance;

public interface QuestionAnswer {
    void getAnswer();

    default void print(String question, QuestionAnswer[] questionAnswers) {
        for (QuestionAnswer x : questionAnswers) {

    }
}
