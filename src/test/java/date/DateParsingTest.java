package date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Created by admin on 12/03/2018.
 */
public class DateParsingTest {
    //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns

    @Test
    public void localDateTimeParse() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse("2017-01-08 12:10", formatter);
        System.out.println(dateTime);
    }

    @Test
    public void localDateParse() {
        LocalDate ld = LocalDate.parse("2018-06-01");
        System.out.println("Date: " + ld);
    }

}
