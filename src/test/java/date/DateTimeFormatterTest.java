package date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by admin on 18/03/2018.
 */
public class DateTimeFormatterTest {

    @Test
    public void dateTimeFormatterTest() {
        LocalTime time = LocalTime.parse("10:15:30", DateTimeFormatter.ISO_TIME);
        System.out.println(time);
        LocalDate date = LocalDate.parse("20131206", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date);
        LocalDateTime dateTime1 = LocalDateTime.parse("Thu, 5 Jun 2014 05:10:40 GMT", DateTimeFormatter.RFC_1123_DATE_TIME);
        System.out.println(dateTime1);
        LocalDateTime dateTime2 = LocalDateTime.parse("2014-11-03T11:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(dateTime2);
        LocalDateTime dateTime3 = LocalDateTime.parse("2014-10-05T08:15:30+02:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.println(dateTime3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse("2017-01-08 12:10", formatter);
        System.out.println(dateTime);
    }
}
