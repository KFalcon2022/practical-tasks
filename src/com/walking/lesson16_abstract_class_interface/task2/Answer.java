package com.walking.lesson16_abstract_class_interface.task2;

interface Answer {
    public void callAnswer();

    static void compare(String question) {
        switch (question) {
            case "Hi":
                new Greeting().callAnswer();
                break;
            case "Bye":
                new Bye().callAnswer();
                break;
            case "How are you":
                new Question().callAnswer();
                break;
            default:
                System.out.println("faq");
                break;
        }
    }
}