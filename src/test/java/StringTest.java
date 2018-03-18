import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 12/03/2018.
 */
public class StringTest {

    //String stream
    @Test
    public void testStreamString(){
        String x="abcd efgh ijkl mnopq rstu vwxyz";
        x.chars().forEach(s->System.out.println((char)s));
        x.chars().filter(s->s!=' ').forEach(s->System.out.print((char)s));
    }

    @Test
    public void testStringJoin() {
        String.join(":", "foobar", "foo", "bar");
    }

    @Test
    public void testCollectorsJoing() {
        System.out.println("foobar:foo:bar"
                .chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .sorted()
                .collect(Collectors.joining()).toString());
    }

    @Test
    public void testRegex() {
        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        Long nb=Stream.of("bob@gmail.com", "alice@hotmail.com")
                .filter(pattern.asPredicate())
                .count();
        System.out.println(nb);
    }


    @Test
    public void stringConcatenation() {
        String s="a"+"b"+"c"+"d";
        //java 5 le compilateur optimise ainsi
        String s2=new StringBuilder("a").append("b").append("c").append("d").toString();

        String s3=(Arrays.asList("a", "b", "c", "d")).stream().reduce("",(x,y)->x+y);
        //le compilateur ne voit que 2 addition donc ne pourra pas optimiser
        System.out.println(s3);
    }

    //optimiser utilise stringjoiner qui utilise stringbuilder
    @Test
    public void CollectorsJoin() {
        List<String> listString = Arrays.asList("a", "b", "c", "d");
        //creer mon propre collector
        System.out.println(listString.stream().collect(StringBuilder::new,
                                                        StringBuilder::append,
                                                        StringBuilder::append).toString());
//StringBuilder mutable peut etre utilise avec collect mais pas reduce
        System.out.println(listString.stream().collect(()->new StringBuilder(),
                (s1,s2)->s1.append(s2),
                (s1,s3)->s1.append(s3)).toString());
        //legerement plus performante mais avec avantage prefixe suffixe
        System.out.println(listString.stream().collect(Collectors.joining(";","[","]")));
//compile s xecute donne le bon resultat si execute dans l ordre

        System.out.println(listString.stream().reduce(new StringBuilder(),
                StringBuilder::append,
                StringBuilder::append));
        //sb mutable ko
        System.out.println(listString.stream().parallel().reduce(new StringBuilder(),
                StringBuilder::append,
                StringBuilder::append));

        System.out.println(listString.stream().parallel().reduce(new StringBuilder(),
                (s1,s2)->new StringBuilder(s1).append(s2),
                StringBuilder::append));
    }


    @Test
    public void stringJoinerTest() {
        StringJoiner sj = new StringJoiner("-","{", "}");
        //StringJoiner sj = new StringJoiner("-");
        sj.add("a").add("b").add("c");;
        System.out.println(sj);

        StringJoiner otherSj = new StringJoiner(":", "(", ")");
        otherSj.add("1").add("2").add("3");
        sj.merge(otherSj);
        System.out.println(sj);

        System.out.println(sj.length());

    }

    @Test
    public void stringJoinerCompareStringBuilderTest() {

        final List<String> strings = Arrays.asList("a", "b", "c");
        System.out.println(strings.stream().collect(Collectors.joining(", ")));


        System.out.println(
                strings.stream().collect(Collector.of(StringBuilder::new,
                        (stringBuilder, str) -> stringBuilder.append(str).append(", "),
                        StringBuilder::append,
                        StringBuilder::toString))
        );
    }

    @Test
    public void stringBuilderAccept(){
        Stream.Builder<String> b = Stream.builder();
        b.accept("a");
        b.accept("b");
        b.accept("c");
        b.accept("d");
        b.accept("e");

        Stream<String> s = b.build();
        s.forEach(System.out::println);
    }

    @Test
    public void stringBuilderAdd(){
        Stream.Builder<String> b = Stream.builder();
        b.add("a").add("b").add("c").add("d").add("e");

        Stream<String> s = b.build();
        s.forEach(System.out::println);
    }
    //DoubleStream.Builder IntStream.Builder LongStream.Builder




}
