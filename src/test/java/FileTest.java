import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("List: " + joined);
        }
    }

    @Test
    public void testFindFile() throws IOException {
        Path start = Paths.get("");
        int maxDepth = 5;
        try (
                Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                        String.valueOf(path).endsWith(".xml"))
        )

        {
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining("; "));
            System.out.println("Found: " + joined);
        }

    }
    @Test
    public void testFindFileWalk() throws IOException {
        Path start = Paths.get("");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> path.endsWith(".xml"))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("walk(): " + joined);
        }
    }

    @Test
    public void testReader() throws IOException {
        Path path = Paths.get("res/nashorn1.js");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println(reader.readLine());
        }
    }

    @Test
    public void testWriter() throws IOException {
        Path path = Paths.get("res/output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("print('Hello World');");
        }
    }

    @Test
    public void streamReader() throws IOException {
        Path path = Paths.get("res/nashorn1.js");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            long countPrints = reader
                    .lines()
                    .filter(line -> line.contains("print"))
                    .count();
            System.out.println(countPrints);
        }
    }
}
