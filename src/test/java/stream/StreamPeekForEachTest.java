package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 11/03/2018.
 */
public class StreamPeekForEachTest {
    /*Un stream est un objet qui sert a definir des operations
      - a une source de donnee
      - ne modifie pas la source
      - traitement est optimise
    */

    //distinct sort bufferiser
    //limit skip gere un compteur
    List<Integer> list = Arrays.asList(1, 4, 3, 2);

    @Test
    public void streamPeek() {
        list.stream().peek(System.out::print); //Declaratif pas d'operation terminal
    }

    //list.stream().forEachOrdered(System.out::println);
    //list.stream().skip(2).forEach(s->System.out.println(s));
    //Object[] ob = Stream.of("A","B","C","D").toArray();

    @Test
    public void streamPeekOperationTerminal() {
        list.stream().peek(System.out::print).count(); // operation terminal
    }


    @Test
    public void streamForEach() {
        list.stream().forEach(System.out::print);
    }


}
