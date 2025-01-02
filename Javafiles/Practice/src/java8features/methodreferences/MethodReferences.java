package java8features.methodreferences;

import java.util.List;
import java.util.stream.Collectors;

//method references(short hand of lambda exp) 4 types.
public class MethodReferences {
    public static void main(String[] args) {
        var list= List.of(10,20,30,40);
        List<String> list1= List.of("Harsh","Karan","Lokesh","Mohit");
        list.forEach(System.out::println); // static method reference.
        list.forEach(i->System.out.println(i+" ")); // cannot do with method reference.
        list1.stream().map(s->s.toUpperCase()).forEach(System.out::println) ;
        list1.stream().map(String::toUpperCase).forEach(System.out::println) ;// instance method reference
        list1.stream().map(StringBuilder::new).forEach(System.out::println); // Constructor method  reference to StringBuilder(String)


    }
}
