import org.junit.Test;
import stream.Personne;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by admin on 17/03/2018.
 */
public class ReflectionTest {

    @Test
    public void reflectMethodTest() {
        Method[] methods = Personne.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter p : parameters) {
                if (p.isNamePresent()) {
                    System.out.println(p.getName());
                }
            }
        }
    }

    //TODO
    @Test
    public void reflectConstructeurTest() {
        Constructor<?>[] constructors = Personne.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
            System.out.println("-------------");
            Parameter[] parameters = constructor.getParameters();
            for (Parameter p : parameters) {
                if (p.isNamePresent()) {
                    System.out.println(p.getName());
                }
            }
        }
    }
}
