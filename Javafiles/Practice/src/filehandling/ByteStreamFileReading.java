package filehandling;

import java.io.*;
import java.util.Scanner;

public class ByteStreamFileReading {
    public static void main(String[] args) {
         try {
             InputStream input = new FileInputStream("data.txt");
             // reading one character at a time
//             int ch;
//             while((ch=input.read())!=-1){
//                 System.out.print((char)ch);
//             }
             // reading one line at a time.
             Scanner sc=new Scanner(input);
             while(sc.hasNextLine()) {
                 String line = sc.nextLine();
                 System.out.println(line);
             }
         }catch(IOException ex) //Ioexception is super exception among  all file exceptions
         {
             System.err.println(ex.getMessage());
         }
         writingFile();;
    }
    public static void writingFile(){
        try(OutputStream output=new FileOutputStream("data.txt")) { //try with resources.
            String lines= """
                   Hello all,
                   we are writing data on a file
                   """;
            output.write(lines.getBytes());

        }catch(IOException ex)
        {
            System.err.println(ex.getMessage());
        }

    }

}
