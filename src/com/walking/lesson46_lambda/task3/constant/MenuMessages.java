package com.walking.lesson46_lambda.task3.constant;

public class MenuMessages {
    public static final String MAIN_MENU_MESSAGE = """
            Выбор поиска
            1 - поиск машины по номеру;
            2 - поиск машины по части номера;
            3 - поиск машины по цвету;
            4 - поиск машины по промежутку года;
            
            0 - выход.
            """;

    public static final String INCORRECT_INPUT_MESSAGE = "Не корректный ввод, пробуй ещё";

    public static final String SEARCH_BY_NUMBER_MESSAGE = """
            Выбор - поиск по номеру
            Введи интересующий номер:
            """;

    public static final String SEARCH_BY_NUMBER_SUBSTRING_MESSAGE = """
            Выбор - поиск по части номера
            Введи интересующую часть номера:
            """;

    public static final String SEARCH_BY_COLOR_MESSAGE = """
            Выбор - поиск по цвету
            Введи интересующий цвет:    
            """;

    public static final String SEARCH_BY_YEAR_BETWEEN_MESSAGE = "Выбор поиск по промежутку года";
    public static final String SEARCH_BY_YEAR_BETWEEN_FIRST_INPUT = "введи год от которого искать:";
    public static final String SEARCH_BY_YEAR_BETWEEN_SECOND_INPUT = "введи год до которого искать:";

    public static final String EMPTY_RESULT_MESSAGE = "Результатов не найдено.\n";

    private MenuMessages() {

    }
}
