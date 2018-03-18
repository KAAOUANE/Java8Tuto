package date;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by admin on 12/03/2018.
 */
public class LocalDateTimeTest {

    @Test
    public void localDateTimeTest(){
    LocalDateTime localdt1 = LocalDateTime.now();
    System.out.println(localdt1);
    LocalDateTime localdt2 = LocalDateTime.now(Clock.systemDefaultZone());
    System.out.println(localdt2);
    System.out.println(LocalDateTime.now(ZoneId.of("Indian/Cocos")));
    System.out.println(LocalDateTime.now(ZoneId.of("America/Caracas")));
    }

}
