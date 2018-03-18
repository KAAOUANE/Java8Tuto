package interfaceFonctionnel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by admin on 11/03/2018.
 */
public class ConsumerTest {

    @Test
    public void consumerAcceptTest() {
        Consumer<String> function = x -> System.out.println(x);
        Consumer<String> function2 = x -> System.out.println(x.toLowerCase());
        consumeString(function, "StringA");
        consumeString(function2, "StringA");

    }

    public static void consumeString(Consumer<String> consumer, String x) {
        consumer.accept(x);
    }

    @Test
    public void consumerTest() {
        List<String> liste = Arrays.asList("a", "b", "c", "d");
        Consumer<String> c1 = liste::add;
        Consumer<String> c2 = System.out::println;
        Consumer<String> c3 = s -> System.out.print(s + "--");

        liste.stream().peek(c2).count();
        System.out.println();
        System.out.println("--------------------------------");
        liste.stream().peek(c2.andThen(c3)).count();
        System.out.println();
        System.out.println("--------------------------------");
        liste.stream().peek(c3.andThen(c2)).count();



//        liste.stream().peek(c3).count();
//        liste.stream().peek(c1).peek(c2).count();

    }


}
