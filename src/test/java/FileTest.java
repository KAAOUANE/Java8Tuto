import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 12/03/2018.
 */
public class FileTest {

    //class Files a ete introduite en Java 7
    //Java 8 a introduit des methodes qui facilite la manipulation avec des stream

    @Test
    public void testListFile() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get("src/test/ressources"))) {
            String joined = stream
                    .map(s->s.getFileName().toString())
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("List: " + joined);
        }
    }

    @Test
    public void testFindFile() throws IOException {
        Path start = Paths.get("src/test");
        int maxDepth = 5;
        try (
                Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                        String.valueOf(path).endsWith(".txt"))
        )

        {
            String joined = stream
                    .sorted()
                    .map(s->s.getFileName().toString())
                    .collect(Collectors.joining("; "));
            System.out.println("Found: " + joined);
        }

    }
    @Test
    public void testFindFileWalk() throws IOException {
        Path start = Paths.get("src/test");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> path.endsWith(".txt"))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("walk(): " + joined);
        }
    }

    @Test
    public void testReaderFilesLines() throws IOException {

        try (Stream<String> stream = Files.lines(Paths.get("src/test/ressources/file2.txt"))) {
            stream.map(String::toLowerCase).forEach(System.out::println);
        }

        Files.lines(Paths.get("src/test/ressources/file2.txt")).
                map(String::toLowerCase).forEach(System.out::println);
    }

    @Test
    public void testBufferedReader() throws IOException {
        Path path = Paths.get("src/test/ressources/file2.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.lines().map(String::toLowerCase).forEach(System.out::println);
            //System.out.println(reader.readLine());
            //System.out.println(reader.readLine());
        }
    }

    @Test
    public void testScanner(){
        try (Scanner scanner = new Scanner(new File("src/test/ressources/file2.txt"))) {

            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testWriter() throws IOException {
        Path path = Paths.get("src/test/ressources/file.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("print('Hello World');");
        }
    }

    @Test
    public void streamReader() throws IOException {
        Path path = Paths.get("src/test/ressources/file.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            long countPrints = reader
                    .lines()
                    .filter(line -> line.contains("print"))
                    .count();
            System.out.println(countPrints);
        }
    }
}
