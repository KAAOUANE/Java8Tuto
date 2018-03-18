package interfaceFonctionnel;

import org.junit.Before;
import org.junit.Test;
import stream.Personne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by admin on 16/03/2018.
 */
public class InterfaceFunctionnel {

    //La notions d'interface fonctionnelle est rétro-compatible. Cela signifie qu'une interface écrite en Java 7 (ou avant)
    // peut devenir une interface fonctionnelle dans une application Java 8, sans modification, ni même être recompilée.

    List<Personne> liste = new ArrayList<>();

    @Before
    public void init() {
        liste.add(new Personne("v1@v1.fr", "V1", "VENISSIEUX"));
        liste.add(new Personne("l2@l2.fr", "L2", "LYON"));
        liste.add(new Personne("l1@l1.fr", "L1", "LYON"));
        liste.add(new Personne("m1@m1.fr", "M1", "MARSEILLE"));
        liste.add(new Personne("p1@p1.fr", "P1", "PARIS"));
        liste.add(new Personne("p2@p2.fr", "P2", "PARIS"));
        liste.add(new Personne("l3@l3.fr", "L3", "LYON"));
    }



    @Test
    public void insanceAnonymeInterfaceComparator(){
    liste.stream().forEach(p->System.out.println(p.getVille()));
        Collections.sort(liste, new Comparator<Personne>() {
            @Override
            public int compare(Personne o1, Personne o2) {
                return o1.getVille().compareTo(o2.getVille());
            }
        }) ;
        liste.stream().forEach(p->System.out.println(p.getVille()));
    }

    @Test
    public void interfaceFonctionnelComparator(){
        liste.stream().forEach(p->System.out.println(p.getVille()));
        Collections.sort(liste, (Personne o1, Personne o2) ->
        {return o1.getVille().compareTo(o2.getVille());});

        liste.stream().forEach(p->System.out.println(p.getVille()));
    }

    @Test
    public void interfaceFonctionnelLamndaComparator(){
        liste.stream().forEach(p->System.out.println(p.getVille()));
        Collections.sort(liste, ( o1,  o2) -> o1.getVille().compareTo(o2.getVille()));

        liste.stream().forEach(p->System.out.println(p.getVille()));
    }

    //À partir de Java 8, on peut ajouter deux éléments supplémentaires dans une interfaces :
    // des méthodes statiques
    // et des méthodes par défaut.


    // avant JAVA 8, les fonctions étaient manipulées uniquement comme des méthodes,
    // c’est-à-dire comme des fonctions appelables uniquement à partir de l’instance d’un objet (si non statiques).
    // Dans JAVA8 désormais, les fonctions peuvent se désolidariser des objets (et de leur état)
    // pour acquérir le statut d’entités opératoires autonomes et manipulables en tant que telles.

    @Test
    public void interfaceFonctionnel(){
        Display display = () -> "Functional interface with no argument";
        System.out.println(display.show());
        // functional interface with one argument
        Multiply multiply = (int num) -> num*10;
        int res= multiply.multiply(5);
        System.out.println(res);
        // functional interface with two argument
        Add add =(int a, int b) -> a+b;
        int rs = add.addData(15, 20);
        System.out.println(rs);
    }
}
