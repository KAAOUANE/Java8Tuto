package stream;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 13/03/2018.
 */
public class Personne implements Comparable<Personne>  {
    String name;
    String ville;
    String email;
    Integer numero;

    private Set<String> book;


    public Personne(String email, String name, String ville,Integer numero) {
        this.email = email;
        this.name = name;
        this.ville = ville;
        this.numero = numero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getBook() {
        return book;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    public static String getStaticMethode(){
        return "Je suis une methode static";
    }

    @Override
    public String toString() {
        return  name+"/"+ville;
    }

    @Override
    public int compareTo(Personne o) {
        return this.numero.compareTo(o.numero);
    }
}
