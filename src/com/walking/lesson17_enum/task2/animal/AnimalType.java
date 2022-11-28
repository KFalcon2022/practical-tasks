package com.walking.lesson17_enum.task2.animal;

public enum AnimalType {
    DOG("woof"),
    CAT("meow"),
    COW("moo");

    private final String voice;

    AnimalType(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    //    Следуем изначальному условию задачи, где указано, что метод должен выводить "голос" в консоль.
//    Само собой, в общем случае это не корректно и стоило бы возвращать из метода строку
    public void sound() {
        System.out.println(voice);
    }
}
