package date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by admin on 18/03/2018.
 */
public class PeriodTest  {
    @Test
    public void periodTest(){
        LocalDate start = LocalDate.now();
        System.out.println("Period.between:"+ Period.between(start, LocalDate.MAX).getDays());
        System.out.println("Period.ofDays:"+Period.ofDays(5).getDays());
    }
}
