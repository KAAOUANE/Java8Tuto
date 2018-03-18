import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import stream.Personne;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 12/03/2018.
 */
public class CollectorsTest {

    List<Personne> liste = new ArrayList<>();

    @Before
    public void init() {
        liste.add(new Personne("v1@v1.fr","V1", "VENISSIEUX"));
        liste.add(new Personne("l2@l2.fr","L2", "LYON"));
        liste.add(new Personne("l1@l1.fr","L1", "LYON"));
        liste.add(new Personne("m1@m1.fr","M1", "MARSEILLE"));
        liste.add(new Personne("p1@p1.fr","P1", "PARIS"));
        liste.add(new Personne("v2@v2.fr","V2", "VENISSIEUX"));
        liste.add(new Personne("p2@p2.fr","P2", "PARIS"));
        liste.add(new Personne("l3@l3.fr","L3", "LYON"));
    }
    @Test
    public void CollectorsListToMap() {
        Map<String, Object> map = liste.stream().collect(Collectors.toMap(Personne::getName, Personne::getEmail));
        map.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));
    }

    @Test
    public void CollectorsListToMapWithSupplier() {
        liste.add(new Personne("2 eme l1@l1.fr","L1", "LYON"));
        Map<String, Object> map = liste.stream().collect(Collectors.toMap(Personne::getName, Personne::getEmail,
                (x, y) -> x+", "+ y, LinkedHashMap::new));
        map.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));
    }

    @Test
    public void CollectorsTest() {
        System.out.println(liste.stream().collect(Collectors.groupingBy(p -> p.getVille())));
        System.out.println(liste.stream().collect(Collectors.partitioningBy(p -> "LYON".equals(p.getVille()))));
        System.out.println(liste.stream().collect(Collectors.counting()));
        System.out.println(liste.stream().map(p -> p.getName()).collect(Collectors.joining(",", "[", "]")));
        System.out.println(liste.stream().collect(Collectors.maxBy((p1, p2) -> p1.getVille().compareTo(p2.getVille()))));
        System.out.println(liste.stream().collect(Collectors.groupingByConcurrent(p -> p.getVille())));
    }

    @Test
    public void CollectorsToSet(){
        Stream<String> s = Stream.of("a","b","c");
        Set<String> names = s.collect(Collectors.toSet());
        System.out.println(names);
    }

    @Test
    public void CollectorsMaxMin() {
        List<Integer> list = Arrays.asList(1, 2, 1, 4, 4);
        Assertions.assertThat(list.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get()).isEqualTo(1);
        Assertions.assertThat(list.stream().collect(Collectors.maxBy((x,y)->x>y?1:-1)).get()).isEqualTo(4);
        //calculer max min avec reduce
    }

}
