package interfaceFonctionnel;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static interfaceFonctionnel.ConsumerTest.consumeString;

/**
 * Created by admin on 15/03/2018.
 */
public class SupplierTest {

    @Test
    public void supplierGetTest() {
        Supplier<String> supplier1 = () -> "String1";
        Supplier<String> supplier2 = () -> "String2";
        Supplier<String> supplier3 = () -> null;
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());
        System.out.println(supplier3.get());
    }


}
