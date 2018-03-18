package collections;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 12/03/2018.
 */
public class MapTest {

    Map<String, Integer> superDev = new HashMap<>();

    @Before
    public void init() {
        superDev.put("Sebastien Onde", 10);
        superDev.put("Aboudou Sarre", 10);
        superDev.put("Ousmane Cisse", 10);
    }


    @Test
    public void testcompute() {
        superDev.compute("Ousmane Cisse",(a, b)->(b+10));
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
    }

    @Test
    public void testcomputeIfAbsent() {
        superDev.computeIfAbsent("Mansour Bey", b->28);
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
    }

    @Test
    public void testcomputeIfPresent() {
        superDev.computeIfPresent("Nourredine Lakehal", (a, b) ->28);
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
    }

    @Test
    public void testgetOrDefault() {
        System.out.println(superDev.getOrDefault("Nourredine Lakehal",1));
        System.out.println(superDev.getOrDefault("Sebastien Onde",1));
    }

    @Test
    public void testmerge() {
        superDev.merge("Marie Therese",19,(a, b)->a+b);
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
    }

    @Test //si n existe pas retourne null sinon retourne la value
    public void testputIfAbsent() {
        System.out.println(superDev.putIfAbsent("Makhfoud", 2));
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
        System.out.println(superDev.putIfAbsent("Makhfoud", 2));
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
    }

    @Test
    public void testremoveKeyValue() {
        superDev.remove("Marie Therese",19);
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
    }

    @Test
    public void testreplaceknew() {
        superDev.replace("Sebastien Onde",20);
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
    }

    @Test
    public void testreplacekoldnew() {
        superDev.replace("Aboudou Sarre",10,30);
        superDev.forEach((a, b)->System.out.println(a + "-->" + b));
    }
}
