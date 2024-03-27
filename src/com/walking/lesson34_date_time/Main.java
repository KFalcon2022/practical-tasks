package Lesson33;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();

        //Printing localDateTime in a raw format:
        System.out.println("Raw LocalDateTime: " + localDateTime + "\n");

        String formattedString = DateTests.DateTimeIntoString(localDateTime);
        LocalDateTime unwrappedDateTime = DateTests.stringToLocalDateWithDateTimeFormatter(formattedString);

        Calendar calendar = Calendar.getInstance();

        //Printing calendar in a raw format:
        System.out.println("Raw Calendar: " + calendar + "\n");

        //Printing calendar using getTime() method:
        Date date = calendar.getTime();
        System.out.println("Raw Calendar into Date using calendar.getTime(): " + date + "\n");

        //Wrapping Date into String using SimpleDateFormat:
        String formattedDate = DateTests.DateTimeIntoString(date);
        DateTests.stringToCalenderWithSimpleDateFormat(formattedDate);

        //Compare 2 different Dates:
        DateTests.isBeforeOrAfter(DateTests.DateTimeIntoString(new Date()), formattedDate);

        //Show the difference between 2 Dates
        System.out.println(DateTests.differenceBetweenDates(
                DateTests.stringToCalenderWithSimpleDateFormat("20.12.2022 20:16:00"),
                DateTests.stringToCalenderWithSimpleDateFormat("28.06.1932 02:51:56")));
    }
}
