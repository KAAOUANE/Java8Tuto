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
        printSuppliedString(supplier1);
        printSuppliedString(supplier2);
    }

    public static void printSuppliedString(Supplier<String> supplier){
        System.out.println(supplier.get());
    }

}
