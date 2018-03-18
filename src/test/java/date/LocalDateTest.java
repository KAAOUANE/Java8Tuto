package date;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by admin on 12/03/2018.
 */
public class LocalDateTest {

    @Test
    public void localDateTest() {
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.now(Clock.systemDefaultZone());
        System.out.println(localDate2);
        System.out.println(LocalDate.now(ZoneId.of("Indian/Cocos")));
        System.out.println(LocalDate.now(ZoneId.of("America/Caracas")));
        System.out.println(LocalDate.now(ZoneId.of("Pacific/Norfolk")));
    }
}
