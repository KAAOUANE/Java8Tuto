package stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 12/03/2018.
 */
public class StreamFilterTest {


    List<Personne> liste = new ArrayList<>();

    @Before
    public void init() {
        liste.add(new Personne("v1@v1.fr","V1", "VENISSIEUX",1));
        liste.add(new Personne("l2@l2.fr","L2", "LYON",2));
        liste.add(new Personne("l1@l1.fr","L1", "LYON",3));
        liste.add(new Personne("m1@m1.fr","M1", "MARSEILLE",4));
        liste.add(new Personne("p1@p1.fr","P1", "PARIS",6));
        liste.add(new Personne("v2@v2.fr","V2", "VENISSIEUX",5));
        liste.add(new Personne("p2@p2.fr","P2", "PARIS",9));
        liste.add(new Personne("l3@l3.fr","L3", "LYON",8));
    }

    @Test
    public void streamFilter() {
        List<Personne> list1 = liste.stream().filter(p -> "LYON".equals(p.getVille())).collect(Collectors.toList());
        list1.stream().forEach(System.out::println);
    }
}
