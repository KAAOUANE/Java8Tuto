import org.junit.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by admin on 17/03/2018.
 */
public class RandomTest {
    private static final List<Integer> VALID_PWD_CHARS = new ArrayList<>();
    static {
        IntStream.rangeClosed('0', '9').forEach(VALID_PWD_CHARS::add);    // 0-9
        IntStream.rangeClosed('a', 'z').forEach(VALID_PWD_CHARS::add);    // a-z
    }
    @Test
    public void testRandom(){

        int passwordLength = 8;
        System.out.println("---Generated Password---");
        for(int i=0;i<5;i++) {
            new Random().ints(passwordLength, 0, VALID_PWD_CHARS.size())
                    .map(VALID_PWD_CHARS::get).forEach(s -> System.out.print((char) s));
            System.out.println();
        }


    }
    private static final List<Integer> VALID2_PWD_CHARS = new ArrayList<>();
    static {
        IntStream.rangeClosed('0', '9').forEach(VALID2_PWD_CHARS::add);    // 0-9
        IntStream.rangeClosed('A', 'Z').forEach(VALID2_PWD_CHARS::add);    // A-Z
        IntStream.rangeClosed('a', 'z').forEach(VALID2_PWD_CHARS::add);    // a-z
        IntStream.rangeClosed('!', '*').forEach(VALID2_PWD_CHARS::add);    // !-*
    }
    @Test
    public void testSecureRandom(){
        int passwordLength = 8;
        System.out.println("---Generated Password---");
        for(int i=0;i<5;i++) {
            new SecureRandom().ints(passwordLength, 0, VALID2_PWD_CHARS.size())
                    .map(VALID2_PWD_CHARS::get).forEach(s -> System.out.print((char) s));
            System.out.println();
        }
    }
}
