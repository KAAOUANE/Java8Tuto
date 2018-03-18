package interfaceFonctionnel;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by admin on 15/03/2018.
 */
public class PredicateTest {
    @Test
    public void predicateTestTest() {
        Predicate<Double> function = x -> x > 10;
        Predicate<Double> function2 = x -> x < -10;
        testValue(function,new Double(9));
        testValue(function2,new Double(-20));
    }
    public static void testValue(Predicate<Double> predicate, Double d){
        System.out.println(predicate.test(d));
    }



    @Test
    public void evaluatePredicate() {
        Predicate<Integer> psup2 = x -> x > 2;
        System.out.println(psup2.negate().test(1));
        System.out.println(psup2.test(1));
    }

    @Test
    public void evaluateBiPredicate() {
        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
        BiPredicate<Integer, Integer> eq = (x, y) -> x - 2 > y;

        System.out.println(bi.test(2, 3));  // false
        System.out.println(bi.or(eq).test(2, 3));   // false
        System.out.println(bi.or(eq).test(8, 3));   // true
    }


    @Test
    public void testPredicate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().filter(x -> x > 3).collect(Collectors.toList()).forEach(System.out::println);
        list.stream().filter(x -> x > 2 && x < 4).collect(Collectors.toList()).forEach(System.out::println);
        Predicate<Integer> psup2 = x -> x > 2;
        Predicate<Integer> pinf4 = x -> x < 4;
        list.stream().filter(psup2.and(pinf4)).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void testPredicate2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Predicate<Integer> psup2 = x -> x > 2;
        list.stream().filter(psup2.negate()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(psup2.negate().test(1));
    }
}
