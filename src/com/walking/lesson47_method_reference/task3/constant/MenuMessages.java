package com.walking.lesson47_method_reference.task3.constant;

public class MenuMessages {
    public static final String MAIN_MENU_MESSAGE = """
            Please, choose one of the next items:
            1   - Search cars by number;
            2   - Search cars by number's substring;
            3   - Search cars by color;
            4   - Search cars by year between;
            
            0   - Exit.
            """;

    public static final String INCORRECT_INPUT_MESSAGE = "Incorrect input. Try again.";

    public static final String SEARCH_BY_NUMBER_MESSAGE = """
        You've chosen "Search by number".
        Enter the car number you're interested in:
    """;

    public static final String SEARCH_BY_NUMBER_SUBSTRING_MESSAGE = """
        You've chosen "Search by number's substring".
        Enter the substring  you're interested in:
    """;

    public static final String SEARCH_BY_COLOR_MESSAGE = """
        You've chosen "Search by color".
        Enter the color you're interested in:
    """;

    public static final String SEARCH_BY_YEAR_BETWEEN_MESSAGE = "You've chosen \"Search by year between\".";
    public static final String SEARCH_BY_YEAR_BETWEEN_FIRST_INPUT = "Enter the min year:";
    public static final String SEARCH_BY_YEAR_BETWEEN_SECOND_INPUT = "Enter the max year:";

    public static final String EMPTY_RESULT_MESSAGE = "No results found. Try to change search criteria\n";


    private MenuMessages() {
    }
}
