package stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by admin on 12/03/2018.
 */
public class StreamMapTest {

    List<Personne> liste = new ArrayList<>();

    @Before
    public void init() {
        liste.add(new Personne("v1@v1.fr", "V1", "VENISSIEUX"));
        liste.add(new Personne("l2@l2.fr", "L2", "LYON"));
        liste.add(new Personne("l1@l1.fr", "L1", "LYON"));
        liste.add(new Personne("m1@m1.fr", "M1", "MARSEILLE"));
        liste.add(new Personne("p1@p1.fr", "P1", "PARIS"));
        liste.add(new Personne("v2@v2.fr", "V2", "VENISSIEUX"));
        liste.add(new Personne("p2@p2.fr", "P2", "PARIS"));
        liste.add(new Personne("l3@l3.fr", "L3", "LYON"));
    }

    @Test
    public void streamMap() {
        List<String> list1 = liste.stream().map(p -> p.getName()).collect(Collectors.toList());
        list1.stream().forEach(System.out::println);
    }

    @Test
    public void streamToMap() {
        Map<String, Personne> mapEmailPerson =
                liste.stream()
                        .collect(Collectors.toMap(Personne::getEmail, Function.identity()));

        System.out.println(mapEmailPerson);
    }

    @Test
    public void streamToMapLamnda() {
        Map<String, Personne> mapEmailPerson =
                liste.stream()
                        .collect(Collectors.toMap(p -> p.getEmail(), p -> p));

        System.out.println(mapEmailPerson);
    }

    @Test
    public void streamToMapLamnda2() {
        Map<String, String> mapEmailPerson =
                liste.stream()
                        .collect(Collectors.toMap(p -> p.getEmail(), p -> p.getVille()));

        System.out.println(mapEmailPerson);
    }
    @Test
    public void streamFlatMap() {
        liste.get(0).addBook("Java 8 in Action");
        liste.get(0).addBook("Java 7 in Action");
        liste.get(0).addBook("Java 6 in Action");
        liste.get(1).addBook("Scala in Action");
        liste.get(2).addBook("Groovy in Action");
        List<String> collect =
                liste.stream().filter(x -> x.getBook()!=null)
                        .map(x -> x.getBook())
                        .flatMap(x -> x.stream())
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
    }
    //map
    // flatMap
}
