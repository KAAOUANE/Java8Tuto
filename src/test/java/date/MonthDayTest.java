package date;

import org.junit.Test;

import java.time.MonthDay;

/**
 * Created by admin on 18/03/2018.
 */
public class MonthDayTest {

    @Test
    public void monthDayTest(){
        MonthDay mday = MonthDay.now();
        System.out.println(mday.getDayOfMonth());
        System.out.println(mday.getMonth());
        System.out.println(mday.atYear(2020));
    }
}
