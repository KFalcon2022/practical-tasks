package com.walking.lesson46_lambda.task3.menu;

public class Messages {
    public static final String MAIN_MENU_MESSAGE = """
            Введите номер действия:
            1 - поиск по номеру,
            2 - поиск по владельцу,
            3 - поиск по марке,
            4 - поиск по году выпуска,
            5 - поиск по цвету,
            6 - завершить программу""";

    public static final String NUMBER_MESSAGE = "Введите номер машины или его часть: ";
    public static final String OWNER_MESSAGE = "Введите фамилию и инициалы владельца: ";
    public static final String BRAND_MESSAGE = "Введите марку: ";
    public static final String YEAR_FIRST_MESSAGE = "Введите начало диапозона: ";
    public static final String YEAR_SECOND_MESSAGE = "Введите конец диапозона: ";
    public static final String COLOR_MESSAGE = "Введите цвет: ";

    public static final String PROCEED_MESSAGE = "Введите номер действия: ";
    public static final String WRONG_INPUT = "Ошибка! Выберите цифру от 1 до 6.";

    public static final String CARS_NOT_FOUND_MESSAGE = "Машины, соответствующие условию поиска, не найдены.";

}
