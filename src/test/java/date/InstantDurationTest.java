package date;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by admin on 12/03/2018.
 */
public class InstantDurationTest {

    @Test
    public void instantTest(){
        Instant instant = Instant.now();
        System.out.println(instant);
    }
    @Test
    public void convertUtilDateTest(){
        Instant instant = Instant.ofEpochMilli(new Date().getTime());
        System.out.println(instant);
    }
    @Test
    public void addDurationTest(){
        Instant instant = Instant.now();
        Instant instant1 = instant.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant1);
        System.out.println(instant==instant1); //instant est immutable

    }

    @Test
    public void substractDurationTest(){
        Instant instant = Instant.now();
        Instant instant1 = instant.minus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant1);

    }

    @Test
    public void minuteBetweenInstantsTest(){
        Instant instant = Instant.now();
        Instant instant1 = instant.minus(Duration.ofHours(5).plusMinutes(4));
        //System.out.println(instant. periodUntil(instant1, ChronoUnit.MINUTES));
        System.out.println(ChronoUnit.MINUTES.between(instant1, instant));
    }

    @Test
    public void compareInstantsTest(){
        Instant instant = Instant.now();
        Instant instant1 = instant.minus(Duration.ofHours(5).plusMinutes(4));
        System.out.format("instant1.compareTo(instant)=%d.%n", instant.compareTo(instant1));
        System.out.format("instant1.compareTo(instant)=%d.%n", instant1.compareTo(instant));

        System.out.format("instant1.isAfter(instant)=%b, instant1.isBefore(instant)=%b.%n",
                instant1.isAfter(instant), instant1.isBefore(instant));
    }

}
