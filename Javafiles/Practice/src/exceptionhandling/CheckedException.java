package exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
 // checked exception cannot avoid.
public class CheckedException {
    public static void main(String[] args) {
       // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        FileReader reader=null;
        try {
             reader = new FileReader("C:\\UST\\Javafiles\\Practice\\hello.txt");
            Scanner sc = new Scanner(reader);
            System.out.println(sc.nextLine());
        }catch(FileNotFoundException ex)
        {
            //System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }  finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Scanner scanner = new Scanner(reader);
        System.out.println(scanner.nextLine());


    }
}
