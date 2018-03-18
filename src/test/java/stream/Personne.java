package stream;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 13/03/2018.
 */
public class Personne {
    String name;
    String ville;
    String email;

    private Set<String> book;


    public Personne(String email, String name, String ville) {
        this.email = email;
        this.name = name;
        this.ville = ville;
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

    public void setBook(Set<String> book) {
        this.book = book;
    }

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    @Override
    public String toString() {
        return  name+"/"+ville;
    }
}
