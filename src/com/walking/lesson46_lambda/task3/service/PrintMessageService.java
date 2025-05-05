package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.constant.MessageConstant;

public class PrintMessageService {

    public void printStartMenuMessage() {
        System.out.println(MessageConstant.START_MENU_MESSAGE);
    }

    public void printUnknownCommandMessage() {
        System.out.println(MessageConstant.UNKNOWN_COMMAND_MESSAGE);
    }

    public void printEnterTheColorMessage() {
        System.out.println(MessageConstant.ENTER_THE_COLOR_MESSAGE);
    }

    public void printEnterTheNumberMessage() {
        System.out.println(MessageConstant.ENTER_THE_NUMBER_MESSAGE);
    }

    public void printEnterTheNumberSubstringMessage() {
        System.out.println(MessageConstant.ENTER_THE_NUMBER_SUBSTRING_MESSAGE);
    }

    public void printEnterTheMinYearMessage() {
        System.out.println(MessageConstant.ENTER_THE_MIN_YEAR_MESSAGE);
    }

    public void printEnterTheMaxYearMessage() {
        System.out.println(MessageConstant.ENTER_THE_MAX_YEAR_MESSAGE);
    }

    public void printNoMatchesFoundMessage() {
        System.out.println(MessageConstant.NO_MATCHES_FOUND_MESSAGE);
    }

    public void printEmptyLine(){
        System.out.println(MessageConstant.EMPTY_LINE);
    }
}
