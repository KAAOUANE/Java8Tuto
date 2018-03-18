package date;

import org.junit.Test;

import java.time.OffsetTime;

/**
 * Created by admin on 18/03/2018.
 */
public class OffsetTimeTest {

    @Test
    public void offsetTimeTest(){
        OffsetTime offTime = OffsetTime.now();
        System.out.println(offTime.getHour() +" hour");
        System.out.println(offTime.getMinute() +" minute");
        System.out.println(offTime.getSecond() +" second");
    }
}
