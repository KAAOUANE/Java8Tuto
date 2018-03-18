package stream;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by admin on 14/03/2018.
 */
public class ParallelStream {

    int[] ints={1,2,3,4,5,6,7,8,9};

    @Test
    public void parallelReduce(){
        System.out.println(Arrays.stream(ints).reduce(0,(x,y)->x-y));
        System.out.println(Arrays.stream(ints).parallel().reduce(0,(x,y)->x-y));

        //Attention on obtient pas le meme resultat car en parallele
        //ca depend de la facon dans le tableau sera spliter  et de l accumulateur

        System.out.println(Arrays.stream(ints).reduce(50,(x,y)->x+y));
        System.out.println(Arrays.stream(ints).parallel().reduce(50,(x,y)->x+y));
    }
}
