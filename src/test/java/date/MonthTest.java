package date;

import org.junit.Test;

import java.time.Month;
import java.time.Year;

/**
 * Created by admin on 18/03/2018.
 */
public class MonthTest {

    @Test
    public void monthTest(){
        System.out.println(Month.MARCH);
        System.out.println(Month.MARCH.getValue());
        System.out.println(Month.of(3));
        System.out.println(Month.valueOf("MARCH"));
    }
}
