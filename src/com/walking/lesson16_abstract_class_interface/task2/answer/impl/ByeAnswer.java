package com.walking.lesson16_abstract_class_interface.task2.answer.impl;

import com.walking.lesson16_abstract_class_interface.task2.answer.Answer;

//Обратите внимание на пакет, где находятся наследники.
//Это не обязательная практика, но достаточно распространено вынесение реализаций интерфейса
//в отдельный пакет с названием "impl"
public class ByeAnswer implements Answer {
    @Override
    public String getAnswer() {
//        Опционально, строковый литерал можно вынести в отдельное поле или даже в константу,
//        в зависимости от логики, предполагаемой в дальнейшем.
        return "Good bye";
    }
}
