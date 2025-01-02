package filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NonBlockingInputOutput {
    public static void main(String[] args) throws IOException {
       // readingFile();
       // writingFile();
    }
    public static void readingFile() throws IOException {

        Files.lines(Paths.get("data.txt"))
                .forEach(System.out::println);

//                 Path dir=Paths.get("src");    // explore
//        System.out.println(dir.getFileName());

    }
}
