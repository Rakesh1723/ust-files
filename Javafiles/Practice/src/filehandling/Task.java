package filehandling;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class Task {
    public static void main(String[] args)throws IOException {

        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("""
                    1.Enter text to written
                    2.Read contents of file
                    3.exit
                    Enter your choice :""");
            int op = sc.nextInt();
            sc.nextLine();
//            BufferedWriter writer = null;
            switch (op)
            {
                case 1:
                {
                    System.out.println("enter the text : ");
                    String line = sc.nextLine();
//                    writer = new BufferedWriter(new FileWriter("hello.txt", true));
//                    writer.write(line);
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("hello.txt", true))) {
                        writer.write(line);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 2:
                {
                    Reader input = new FileReader("hello.txt");
                    BufferedReader reader = new BufferedReader(input);
                    System.out.println("Text is ");
                    reader.lines().forEach(System.out::println);
                    break;
                }
                case 3:{
                    exit(0);
                }
            }

        }

    }
}
