package date;

import org.junit.Test;

import java.time.Year;

/**
 * Created by admin on 18/03/2018.
 */
public class YearTest {

    @Test
    public void yearTest(){
        System.out.println("Year.now():"+ Year.now());
        System.out.println("Year.MAX_VALUE:"+Year.MAX_VALUE);
        System.out.println("Year.isLeap(2014):"+Year.isLeap(2014));
        System.out.println("Year.isLeap(2016):"+Year.isLeap(2016));
    }
}
