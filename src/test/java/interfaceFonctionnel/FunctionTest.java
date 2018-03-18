package interfaceFonctionnel;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;

import static interfaceFonctionnel.ConsumerTest.consumeString;

/**
 * Created by admin on 15/03/2018.
 */
public class FunctionTest {

    @Test
    public void functionApplyTest() {
        Function<String, String> functionMajuscule = x -> x.toUpperCase();
        Function<String, String> functionMinuscule = x -> x.toLowerCase();
        convertString("functionMajuscule",functionMajuscule);// prints STRANGE
        convertString("functionMinuscule",functionMinuscule);// prints strange
        convertString("functionMinuscule.andThen(functionMajuscule)",functionMinuscule.andThen(functionMajuscule));
        convertString("functionMajuscule.compose(functionMinuscule)",functionMajuscule.compose(functionMinuscule));
        convertString("functionMinuscule.compose(functionMajuscule)",functionMinuscule.compose(functionMajuscule));
        convertString("Function.identity()",functionMinuscule.compose(Function.identity()));

    }

    public static void convertString(String op,Function<String, String> function){
        System.out.println(op+"-->"+function.apply("StRaNgE"));
    }

    //compose
    //AndThen

}
