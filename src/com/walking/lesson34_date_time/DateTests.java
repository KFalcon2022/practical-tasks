package Lesson33;

import Lesson32.Task1.Car;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTests {

    private static final String MONTH = "Month";
    public static final String MILLIS = "Millis";
    public static final String YEAR = "Year";

    public static String DateTimeIntoString(LocalDateTime localDateTime) {
        //Wrapping localDateTime into a Formatted string. LocalDate/Time uses only DateTimeFormatter:
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedString = localDateTime.format(dateTimeFormatter);
        //Printing the formatted date:
        System.out.println("Formatted LocalDateTime with DateTimeFormatter: " + formattedString + "\n");
        return formattedString;
    }

    public static String DateTimeIntoString(Date date) {
        //Wrapping Date into a SimpleDateFormat string. Date uses only SimpleDateFormat:
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String formattedString = simpleDateFormat.format(date);
        //Printing the formatted date:
        System.out.println("Formatted Date object with SimpleDateFormat: " + formattedString + "\n");
        return formattedString;
    }

    public static LocalDateTime stringToLocalDateWithDateTimeFormatter(String date) {
        //Creating a pattern for format. LocalDate/Time uses only DateTimeFormatter:
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        //Unwrapping the String using .parse(String, DateTimeFormatter) method:
        LocalDateTime unwrappedDateTime = LocalDateTime.parse(date, dateTimeFormatter);
        System.out.println("Unwrapped LocalDateTime (using .parse(String, DateTimeFormatter) method for LocalDateTime: " + unwrappedDateTime + "\n");
        return unwrappedDateTime;
    }
    public static Calendar stringToCalenderWithSimpleDateFormat(String stringDate) throws ParseException {
        //Creating a pattern for format. Date uses only SimpleDateFormat:
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        //Unwrapping the String using .parse(String) method for Date:
        Date unwrappedDate = simpleDateFormat.parse(stringDate);
        System.out.println("Unwrapped Date (using .parse(String) method for Date: " + unwrappedDate + "\n");

        //Getting callender from unwrapped Date:
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(unwrappedDate);
        System.out.println("Getting callender from unwrapped Date using calendar.setTime(unwrappedDate): " + calendar + "\n");

        return calendar;
    }

    public static String isBeforeOrAfter (String date1, String date2) throws ParseException {
        //Creating a pattern for format. Date uses only SimpleDateFormat:
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        //Unwrapping the String using .parse(String) method for Date:
        Date unwrappedFirstDate = simpleDateFormat.parse(date1);
        Date unwrappedSecondDate = simpleDateFormat.parse(date2);

        System.out.println("Unwrapped Dates (using .parse(String) method for both Dates: " +
                "FirstDate: " + unwrappedFirstDate
                + "SecondDate: " + unwrappedSecondDate + "\n");

        //Compare both dates
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(unwrappedFirstDate);
        String output = calendar.before(unwrappedSecondDate) ? unwrappedFirstDate + " is before " + unwrappedSecondDate :
                unwrappedFirstDate + " is after " + unwrappedSecondDate;
        System.out.println(output);
        return output;
    }

    public static String differenceBetweenDates(Calendar date1, Calendar date2) {
        if (date1.equals(date2))
            return "dates are equal";
        long differenceInMillis = calculateDifference(date1, date2, MILLIS);
        long differenceInSeconds = TimeUnit.MILLISECONDS.toSeconds(differenceInMillis);
        long differenceInMinutes = TimeUnit.SECONDS.toMinutes(differenceInSeconds);
        long differenceInHours = TimeUnit.MINUTES.toHours(differenceInMinutes);
        int differenceInDays = (int) TimeUnit.HOURS.toDays(differenceInHours);
        int differenceInMonths = (int) calculateDifference(date1, date2, MONTH);
        long differenceInYears = (int) calculateDifference(date1, date2, YEAR);
        return """
                Seconds: %d
                Minutes: %d
                Hours: %d
                Days: %d
                Months: %d
                Years: %d
                """.formatted(differenceInSeconds, differenceInMinutes, differenceInHours, differenceInDays, differenceInMonths, differenceInYears);
    }
    private static long calculateDifference(Calendar date1, Calendar date2, String instance) {
        Calendar more;
        Calendar less;
        if (date1.before(date2)) {
            less = date1; more = date2;
        } else {
            less = date2; more = date1;
        }
        if (instance.equals(MONTH)) {
            return less.get(Calendar.DAY_OF_MONTH) > more.get(Calendar.DAY_OF_MONTH) ?
                    ((more.get(Calendar.YEAR) - less.get(Calendar.YEAR)) * 12L + (more.get(Calendar.MONTH) - less.get(Calendar.MONTH))) - 1 :
                    ((more.get(Calendar.YEAR) - less.get(Calendar.YEAR)) * 12L + (more.get(Calendar.MONTH) - less.get(Calendar.MONTH)));
        } if (instance.equals(MILLIS))
            return more.getTimeInMillis() - less.getTimeInMillis();
        if (instance.equals(YEAR))
            return more.get(Calendar.YEAR) - less.get(Calendar.YEAR);
        return 0;
    }
}
