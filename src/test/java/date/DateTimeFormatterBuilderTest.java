package date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;

/**
 * Created by admin on 18/03/2018.
 */
public class DateTimeFormatterBuilderTest {

    @Test
    public void dateTimeFormatterBuilderTest() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeFormatter formatter = builder.appendLiteral("Day is:")
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(", month is:")
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(", and year:")
                .appendPattern("u")
                .appendLiteral(" with the time:")
                .appendValue(ChronoField.HOUR_OF_DAY)
                .appendLiteral(":")
                .appendText(ChronoField.MINUTE_OF_HOUR, TextStyle.NARROW_STANDALONE)
                .toFormatter();
        LocalDateTime dateTime = LocalDateTime.now();
        String str = dateTime.format(formatter);
        System.out.println(str);
    }
}
