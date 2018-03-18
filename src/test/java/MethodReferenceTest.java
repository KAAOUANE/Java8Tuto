import interfaceFonctionnel.Display;
import org.junit.Test;
import stream.Personne;

/**
 * Created by admin on 18/03/2018.
 */
public class MethodReferenceTest {

    //Les methodes references peuvent etre utiliser comme alternative au expresion
    //lamnda pour simplifier la lecture du code

    @Test
    public void referenceStaticMethodeFile(){
        //Personne::getStaticMethode();

    }
    @Test
    public void referenceInstanceMethodeFile(){

        //Personne p = new Personne("toto@toto.fr","toto","LYON",1);
        //System.out.println(p::getName);

    }
    @Test
    public void referenceConstructeurFile(){
        //Personne::new;


    }
    @Test
    public void referenceType(){
    //String::isEmpty
    }
    //System.out::println

}
