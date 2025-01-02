package java8features.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsEx2 {
    public static void main(String[] args){
        List<String> list= List.of("Karan","Harsh","Lokesh","Mohit");
//          var sort=list.stream().sorted((a,b)->b.compareTo(a)).toList();
//          sort.forEach(i-> System.out.println(i));
//
//           var start= list.stream().filter(i->i.startsWith("H")||i.startsWith("M")).toList();
//           var start1= list.stream().filter(i->i.charAt(0)=='H'||i.charAt(0)=='M').toList();
//           start1.forEach(i-> System.out.println(i));
//
//           var str=list.stream().reduce((a,b)->a+","+b).get();
//         //  var str=list.stream().reduce((a,b)->a+","+b).orElse("not found");
//           var str1=list.stream().collect(Collectors.joining(","));
//           var str2=String.join(",",list);
//          System.out.println(str);

//        List<String> sortedList = list.stream()
//                .sorted((a, b) -> {
//                    // Compare by length first
//                    int lengthComparison = Integer.compare(a.length(), b.length());
//                    // If lengths are the same, compare alphabetically
//                    if (lengthComparison != 0) {
//                        return lengthComparison;
//                    } else {
//                        return a.compareTo(b);
//                    }
//                })
//                .collect(Collectors.toList());

          flatMapEx(); //it returns streams of streams to  single stream.
    }

    public static void flatMapEx(){

//        List<List<String>> listOfLists = Arrays.asList(
//                Arrays.asList("hello", "from ust"),
//                Arrays.asList("welcome","to onboarding"),
//                Arrays.asList("Java","Programming")
//        );
//
//        listOfLists.stream()
//                .flatMap(list -> list.stream())
//                .forEach(System.out::println);



//        ArrayList<String> res=new ArrayList<>();
//        try {
//              ArrayList<String> al=new ArrayList<>();
//              Files.lines(Paths.get("data.txt")).forEach(i->al.add(i));
//            for(String i:al)
//            {
//                String[] arr=i.split(" ");
//                for(String s:arr) {
//                    res.add(s);
//                }
//            }
//        } catch (IOException ex) {
//             ex.getMessage();
//        }

        try {
            Files.lines(Paths.get("data.txt")).flatMap(i -> Arrays.stream(i.split("\\W"))).forEach(System.out::println);
        }
        catch(IOException ex){
            ex.getMessage();
        }



//      try {
//          String singleLine = Files.lines(Paths.get("data.txt"))
//                  .flatMap(line -> line.chars() // Convert each line to a stream of characters
//                          .mapToObj(c -> Character.toString((char) c))) // Convert characters to strings
//                  .collect(Collectors.joining("")); // Join all substrings into a single string
//          System.out.println(singleLine);
//      }catch(IOException ex)
//      {
//          ex.getMessage();
//      }


    }
}
