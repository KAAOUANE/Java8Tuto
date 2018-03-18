package date;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Created by admin on 12/03/2018.
 */
public class LocalTimeTest {

    @Test
    public void localTimeTest() {
        LocalTime localt1 = LocalTime.now();
        System.out.println(localt1);
        LocalTime localt2 = LocalTime.now(Clock.systemDefaultZone());
        System.out.println(localt2);
        System.out.println(LocalTime.now(ZoneId.of("Indian/Cocos")));
        System.out.println(LocalTime.now(ZoneId.of("America/Caracas")));
        System.out.println(LocalTime.now(ZoneId.of("Pacific/Norfolk")));
    }
}
