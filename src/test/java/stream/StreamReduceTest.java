package stream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 11/03/2018.
 */
public class StreamReduceTest {

    @Test
    public void streamCount() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(list.stream().count()).isEqualTo(4);
        Assertions.assertThat(list.stream().collect(Collectors.counting())).isEqualTo(4);
    }

    //retourne un Optional
    @Test
    public void streamMax() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(list.stream().max(Comparator.naturalOrder()).get()).isEqualTo(4);
        Assertions.assertThat(list.stream().max(Comparator.reverseOrder()).get()).isEqualTo(1);
        Assertions.assertThat(list.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get()).isEqualTo(4);
        System.out.println(list.stream().collect(Collectors.summarizingInt(Integer::byteValue)));
    }

    @Test
    public void streamMin() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(list.stream().min(Comparator.naturalOrder()).get()).isEqualTo(1);
        Assertions.assertThat(list.stream().min(Comparator.reverseOrder()).get()).isEqualTo(4);
        Assertions.assertThat(list.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get()).isEqualTo(1);
    }

    //retourn un boolean
    @Test
    public void streamAllMatch() {
        List<Integer> list = Arrays.asList(1, 1, 1, 1);
        Assertions.assertThat(list.stream().allMatch(i -> i == 1)).isTrue();
        Assertions.assertThat(list.stream().allMatch(i -> i == 2)).isFalse();
    }

    @Test
    public void streamAnyMatch() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(list.stream().anyMatch(i -> i > 3)).isTrue();
        Assertions.assertThat(list.stream().anyMatch(i -> i > 5)).isFalse();
    }

    @Test
    public void streamNoneMatch() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(list.stream().noneMatch(i -> i > 5)).isTrue();
        Assertions.assertThat(list.stream().noneMatch(i -> i > 2)).isFalse();
    }

    @Test
    public void streamFindFirst() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(list.stream().findFirst()).toString();
        Assertions.assertThat(list.stream().findFirst().isPresent()).isTrue();
        list =  new ArrayList<>();
        Assertions.assertThat(list.stream().findFirst().isPresent()).isFalse();
    }

    @Test
    public void streamFindAny() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(list.stream().findAny().get()).isGreaterThan(0).isLessThan(5);
    }

    //reduce meme parallele respecte l ordre contrairement a foreach
    @Test
    public void streamReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(list.stream().reduce((x,y)->x+y).get()).isEqualTo(10);

        list = new ArrayList<>();
        Assertions.assertThat(list.stream().reduce((x,y)->x+y).isPresent()).isFalse();
        Assertions.assertThat(list.stream().reduce(0,(x,y)->x+y)).isEqualTo(0);
    }

    //toArray
}
