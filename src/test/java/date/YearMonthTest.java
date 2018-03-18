package date;

import org.junit.Test;

import java.time.YearMonth;

/**
 * Created by admin on 18/03/2018.
 */
public class YearMonthTest {

    @Test
    public void yearMonthTest(){
        System.out.println("YearMonth.now():"+ YearMonth.now());
        System.out.println("getMonthValue():"+ YearMonth.parse("2014-09").getMonthValue());
        System.out.println("getYear():"+ YearMonth.parse("2014-09").getYear());
        System.out.println("isLeapYear():"+ YearMonth.parse("2014-09").isLeapYear());
    }
}
