package date;

import org.junit.Test;

import java.time.DayOfWeek;

/**
 * Created by admin on 18/03/2018.
 */
public class DayOfWeekTest {

    @Test
    public void dayOfWeekTest() {
        System.out.print(DayOfWeek.MONDAY.getValue());
        System.out.println(DayOfWeek.of(1));
        System.out.print(DayOfWeek.THURSDAY.getValue());
        System.out.println(DayOfWeek.of(2));
        System.out.print(DayOfWeek.SUNDAY.getValue());
        System.out.println(DayOfWeek.of(7));
    }
}
