import com.sun.deploy.util.StringUtils;
import interfaceFonctionnel.Display;
import org.junit.Test;
import stream.Personne;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static stream.Personne.getStaticMethode;

/**
 * Created by admin on 18/03/2018.
 */
public class MethodReferenceTest {

    //Les methodes references peuvent etre utiliser comme alternative au expresion
    //lamnda pour simplifier la lecture du code
    @Test
    public void referenceStaticMethodeTest(){
        Display display = Personne::getStaticMethode;
        System.out.println(display.show());
        System.out.println(Personne.getStaticMethode());
    }

    @Test
    public void referenceInstanceMethodeTest(){
        Personne p = new Personne("toto@toto.fr","toto","LYON",1);
        Display display = p::getName;
        System.out.println(display.show());
        System.out.println(p.getName());
    }

    interface Messageable{
        Message getMessage(String msg);
    }
    class Message{
        Message(String msg){
            System.out.print(msg);
        }
    }

    @Test
    public void referenceConstructeurTest(){
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }


    @Test
    public void referenceType() {
        System.out.println(Stream.of("", "a", "c").filter(String::isEmpty).count());
        //System.out.println(Stream.of("","a","c").filter(String::!isEmpty).count());
        System.out.println(Stream.of("", "a", "c").filter(s -> !s.isEmpty()).count());
        System.out.println(Stream.of("", "a", "c").filter(((Predicate<String>) String::isEmpty).negate()).count());
        Stream.of("", "a", "c").filter(((Predicate<String>) String::isEmpty).negate()).forEach(System.out::println);
    }

}
