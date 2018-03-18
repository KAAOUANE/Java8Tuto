package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by admin on 13/03/2018.
 */
public class PrimitiveStreamTest {

    @Test
    public void primitiveStream(){
        //List<int>
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //optimizer evite boxing unboxing
        IntStream.range(1, 4).forEach(i->System.out.print(i));
        System.out.println("--");
        IntStream.rangeClosed(1, 4).forEach(i->System.out.print(i));
        System.out.println("--");
        IntStream.of(1, 2, 3,4).forEach(i->System.out.print(i));
        System.out.println("--");
        IntStream.iterate(0, i -> i + 2).limit(3).forEach(i->System.out.print(i));
        System.out.println("--");
        IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).limit(3).forEach(i->System.out.print(i));
        System.out.println("--");
        IntStream.range(1, 5).map(i -> i * i).forEach(i->System.out.print(i));

        //Transformation
        Stream<Integer> streamI = IntStream.range(1, 5).boxed();
        DoubleStream streamD = IntStream.range(1, 5).mapToDouble(i -> i);
        LongStream streamL = IntStream.range(1, 5).mapToLong(i -> i);
        //DoubleStream
        //LongStream

    }

    @Test
    public void mapInt(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(list.stream().reduce(0,(p1,p2)->p1+p2));
        //System.out.println(list.mapToInt().reduce(0,(p1,p2)->p1+p2));

    }
}
