package date;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * Created by admin on 18/03/2018.
 */
public class ZonedDateTimeTest {

    @Test
    public void zoneDateTimeTest(){
        System.out.println(ZonedDateTime.now());
        ZonedDateTime zdt = ZonedDateTime.parse("2018-09-12T10:15:30+01:00[Europe/Paris]");
        System.out.println("getDayOfYear:"+zdt.getDayOfYear());
        System.out.println("zdt.getYear():"+zdt.getYear());
    }
}
