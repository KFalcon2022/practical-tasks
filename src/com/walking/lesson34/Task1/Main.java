package com.walking.lesson34.Task1;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static final String pattern = "%25s => %s\n";

    public static void main(String[] args){
        String[] examples = {
                "20.12.2022 20:16:00",
                "5.11.1988 1:1:1",
                "20.122.2022 20:126:00"
        };

        printDatesWithSimpleDateFormat(examples);
        printDatesWithLocalDate(examples);
    }

    public static void printDatesWithSimpleDateFormat(String[] examples){
        System.out.println("as SimpleDateFormat");
        SimpleDateFormat fmt = new SimpleDateFormat("d.M.y H:m:s");
        for (String s : examples){
            try{
                System.out.printf(pattern, s, fmt.parse(s));
            } catch (ParseException e){
                System.out.printf(pattern, s, "Error converting line");
            }
        }
    }

    public static void printDatesWithLocalDate(String[] examples){
        System.out.println("as LocalDate");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d.M.y H:m:s");
        for (String s : examples){
            try{
                System.out.printf(pattern, s, LocalDate.from(fmt.parse(s)));
            } catch (DateTimeParseException e){
                System.out.printf(pattern, s, "Error converting line");
            }
        }
    }
}
