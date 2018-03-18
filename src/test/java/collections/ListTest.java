package collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * Created by admin on 12/03/2018.
 */
public class ListTest {
    List<Integer> liste = new ArrayList<>();

    @Before
    public void init() {
        for (int i = 0; i < 10; i++) liste.add(i);
    }

    @Test //existe sur tous les iterable
    public void testForEach() {
        //Java 8 iteration interne
        liste.forEach(System.out::println);

    }

    @Test //existe sur toutes les collections
    public void testRemoveIf() {
        liste.removeIf(integer -> integer > 5);
        liste.forEach(System.out::println);
    }

    @Test //existe sur toutes les collections
    public void testReplaceAll() {
        liste.replaceAll(p -> p * 2);
        liste.forEach(System.out::println);
    }

    //TODO MKA
    @Test //existe sur toutes les collections
    public void testSpliterator() {
        Spliterator<Integer> spliterator= liste.spliterator();
        System.out.println(spliterator.characteristics());
        System.out.println(spliterator.estimateSize());//ORDERED, SORTED and SUBSIZED[10].

        Spliterator<Integer> newPartition = spliterator.trySplit();
        System.out.println(" " + newPartition.estimateSize());
        System.out.println(" " + newPartition.estimateSize());

    }

    @Test //seulemet List
    public void testSort() {
        //liste.sort(Integer::compareTo);
        liste.forEach(System.out::print);
        liste.sort((a, b) -> a > b ? -1 : 1);
        System.out.println();
        liste.forEach(System.out::print);
    }

}
