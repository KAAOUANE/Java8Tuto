package collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

/**
 * Created by admin on 12/03/2018.
 */
public class ParallelArrays {



    @Test
    public void testParallelSort() {
        int[] arr = {5, 8, 1, 0, 6, 9};
        Arrays.parallelSort(arr);
        //Arrays.parallelSort(arr, Comparator.naturalOrder());
        for (int i : arr) {
            System.out.print(i + " ");
        }
        //Arrays.stream(arr).forEach(System.out::println);

    }
    @Test
    public void testParallelSortStartEndIndex() {
        int[] arr = {5, 8, 1, 0, 6, 9};
        Arrays.parallelSort(arr,0,4);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    @Test
    public void testParallelPrefix() {
        //IntBinaryOperator intOpt = (i1, i2) -> i1 * i2;
        int[] arr = {5, 8, 1, 2, 6, 9};
        Arrays.parallelPrefix(arr, (i1, i2) -> i1 * i2);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }

    @Test
    public void testParallelPrefixStratEnd() {
        //IntBinaryOperator intOpt = (i1, i2) -> i1 * i2;
        int[] arr = {5, 8, 1, 2, 6, 9};
        Arrays.parallelPrefix(arr,1,4, (i1, i2) -> i1 * i2);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }


}
