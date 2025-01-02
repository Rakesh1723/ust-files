package filehandling;

import java.io.*;
import java.util.Scanner;

public class CharacterStreamFileReading {
    public static void main(String[] args) {
         writingFile();
         try {
             Reader input = new FileReader("data.txt");
             // reading one character at a time
//             int ch;
//             while((ch=input.read())!=-1){
//                 System.out.print((char)ch);
//             }
             // reading one line at a time.
//             Scanner sc=new Scanner(input);
//             while(sc.hasNextLine()) {
//                 String line = sc.nextLine();
//                 System.out.println(line);
//             }
             BufferedReader reader=new BufferedReader(input);
             reader.lines().forEach(System.out::println);

         }catch(IOException ex)
         {
             System.err.println(ex.getMessage());
         }

    }

    public static void writingFile(){
        Writer output=null;
        try {
           output = new FileWriter("data.txt");

           String lines= """
                   Hello all,
                   we are writing character data on a file
                   """;
            output.write(lines); // both write and append done
          //  output.write(lines); // only append

        }catch(IOException ex)
        {
            System.err.println(ex.getMessage());
        }
        finally {
            try{
                output.close();
            }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        }

    }

}
