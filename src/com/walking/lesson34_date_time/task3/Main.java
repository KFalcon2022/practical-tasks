package com.walking.lesson34_date_time.task3;

import com.walking.lesson34_date_time.task3.service.DateService;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static void main(String[] args) {
        DateService dateService = DateService.betweenTwo();

        System.out.println("\n" + dateService.getReport());

        /* альтернативный вариант через наследников TemporalAccessor */
        System.out.println(dateService.getAlternativeView());
    }
}
