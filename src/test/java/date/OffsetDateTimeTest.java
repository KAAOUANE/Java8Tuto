package date;

import org.junit.Test;

import java.time.OffsetDateTime;

/**
 * Created by admin on 18/03/2018.
 */
public class OffsetDateTimeTest {

    @Test
    public void offsetDateTimeTest(){
        OffsetDateTime offsetDT = OffsetDateTime.now();
        System.out.println(offsetDT.getDayOfMonth());
        System.out.println(offsetDT.getDayOfYear());
        System.out.println(offsetDT.getDayOfWeek());
        System.out.println(offsetDT.toLocalDate());
    }
}
