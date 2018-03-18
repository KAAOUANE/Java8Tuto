import org.junit.Before;
import org.junit.Test;
import stream.Personne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;

/**
 * Created by admin on 12/03/2018.
 */
public class ComparatorTest {

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
    public void testComparator(){

        Comparator<Personne> numeroComparator = Comparator.comparing(Personne::getNumero);
        liste.stream().sorted(numeroComparator).forEach(s->System.out.println(s.getNumero()+" " +s.getName()));
        liste.stream().sorted(numeroComparator.reversed()).forEach(s->System.out.println(s.getNumero()+" " +s.getName()));

        Collections.sort(liste, numeroComparator);
        liste.forEach(s->System.out.println(s.getNumero()+" " +s.getName()));
    }

    @Test
    public void testThenComparator(){

        Comparator<Personne> numeroComparator = Comparator.comparing(Personne::getNumero);
        Comparator<Personne> nameComparator = Comparator.comparing(Personne::getName);
        liste.stream().sorted(nameComparator.thenComparing(numeroComparator)).forEach(s->System.out.println(s.getNumero()+" " +s.getName()));
    }

    @Test
    public void testNaturalOrder(){
        //n est possible que si Personne implemet Comparable
        liste.stream().sorted(naturalOrder()).forEach(s->System.out.println(s.getNumero()+" " +s.getName()));
        liste.stream().sorted(Comparator.reverseOrder()).forEach(s->System.out.println(s.getNumero()+" " +s.getName()));
    }
}
