package com.walking.lesson47_method_reference.task3.service;

import static com.walking.lesson47_method_reference.task3.constant.MenuMessages.*;

public class MessagePrinterService {
    public void printMainMenuMessage() {
        System.out.println(MAIN_MENU_MESSAGE);
    }

    public void printIncorrectInputMessage() {
        System.out.println(INCORRECT_INPUT_MESSAGE);
    }

    public void printSearchByNumberMessage() {
        System.out.println(SEARCH_BY_NUMBER_MESSAGE);
    }

    public void printSearchByNumberSubstringMessage() {
        System.out.println(SEARCH_BY_NUMBER_SUBSTRING_MESSAGE);
    }

    public void printSearchByColorMessage() {
        System.out.println(SEARCH_BY_COLOR_MESSAGE);
    }

    public void printSearchByYearBetweenMessage() {
        System.out.println(SEARCH_BY_YEAR_BETWEEN_MESSAGE);
    }

    public void printSearchByYearBetweenFirstInputMessage() {
        System.out.println(SEARCH_BY_YEAR_BETWEEN_FIRST_INPUT);
    }

    public void printSearchByYearBetweenSecondInputMessage() {
        System.out.println(SEARCH_BY_YEAR_BETWEEN_SECOND_INPUT);
    }

    public void printEmptyResultMessage() {
        System.out.println(EMPTY_RESULT_MESSAGE);
    }
}
