package com.walking.lesson17_enum.task1.answer;

public enum GreetingType {
    HI("Hi", "Hello"),
    BYE("Bye", "Good bye"),
    HOW_ARE_YOU("How are you", "How are your doing"),
    //    Вынесение UNKNOWN в качестве элемента массива опционально.
//    Это может быть как верным решением, так и нет, в зависимости от точной формулировки ТЗ и
//    дальнейшего развития функциональности приложения
    UNKNOWN(null, "Unknown message");

    private final String greeting;
    private final String answer;

    //    Обратите внимание. Модификаторы доступа не указывают для конструктора в енаме.
//    Он всегда private (можете дописать и убедиться).
//    Попытка использовать другой модификатор доступа вызовет ошибку компиляции
    GreetingType(String greeting, String answer) {
        this.greeting = greeting;
        this.answer = answer;
    }

    //    По условию задачи, в рамках енама должен быть определен поиск значения по фразе,
//    введенной пользователем
    public static GreetingType findGreetingType(String greeting) {
//        Если параметр == null, возвращаем неизвестное сообщение, иначе при вызове equals()
//        в цикле будет вызвано исключение
        if (greeting == null) {
            return UNKNOWN;
        }

        for (GreetingType greetingType : GreetingType.values()) {
            if (greeting.equals(greetingType.greeting)) {
                return greetingType;
            }
        }
//        Если ничего не нашли - сообщение неизвестно для нашего енама
        return UNKNOWN;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getAnswer() {
        return answer;
    }
}
