package com.walking.lesson34_date_time.task2;

import com.walking.lesson34_date_time.task2.model.DateTimeReciever;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        DateTimeReciever dateTimeReciever = new DateTimeReciever();
        dateTimeReciever.inputDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.y HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeReciever.toString(), formatter);
        System.out.println(ComparerDateTime(dateTime, formatter));

    }

    private static String ComparerDateTime (LocalDateTime dateTime, DateTimeFormatter formatter){
        if (dateTime.isBefore(LocalDateTime.now())){
            return "Введённые дата и время (" + dateTime.format(formatter) +
                    ") раньше текущих (" + LocalDateTime.now().format(formatter) + ")!";
        }else if (dateTime.isAfter(LocalDateTime.now())) {
            return "Введённые дата и время (" + dateTime.format(formatter) +
                    ") позже текущих (" + LocalDateTime.now().format(formatter) + ")!";
        }else{
            return "Введённые дата и время (" + dateTime.format(formatter) +
                    ") равны текущим (" + LocalDateTime.now().format(formatter) + ")!";
        }
    }
}
