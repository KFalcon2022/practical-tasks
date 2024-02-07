package com.walking.lesson61_synchronized.service;

public class CarServicePrintMessages {
    public static final String CAR_NOT_FOUND = "Ooops! Your car is not found";
    public static final String CAR_GET_PARAMETERS_INDEX_MESSAGE = """
                        
            What do you want to change?
            1. Plate number
            2. Release year
            3. Color
                        
            Enter here:\s
            """;
    public static final String CAR_GET_PARAMETER_MESSAGE = "Enter new parameter: ";
    public static final String PARAMETER_CHOOSING_ERROR = "You entered wrong index";
    public static final String CAR_SEARCH_ERROR = "This car doesn't exist in the list!";
}
