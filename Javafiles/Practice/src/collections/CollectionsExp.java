package collections;

import collections.model.Trainee;

import java.util.*;

public class CollectionsExp {
    public static void main(String[] args) {
        Collection item=new ArrayList();
        item.add(10);
        item.add("Laptop");
        item.add(7.5);
        item.add(true);
        item.remove(7.5);

//        for(var i:item)
//            System.out.println(i);

        //list:
        List<Object> al=new ArrayList<>(); //no generic so we can add anything.
        List<String> list = new Stack<>(); // List implementing stack.
        al.add("phone");
        al.add(6);

        //set

//        Set<String> set = new TreeSet<>(List.of("Abc","Pqr","123","Xyz","Xyz"));
//
//        for (String str:set){
//            System.out.println(str);
//        }



        Trainee t1 = new Trainee(1,"Manya","Telangana");
        Trainee t2 = new Trainee(2,"Russel","Tamilnadu");
        Trainee t3 = new Trainee(3,"Joel","Kerala");
        Trainee t4 = new Trainee(4,"srinivas","Kerala");
        Trainee t5=new Trainee(5,"akash","kerala");

        Set<Trainee> trainees=Set.of(t1,t2,t3,t4,t5);

//        Set<Trainee> mallus=trainees
//                .stream()
//                .filter(t->t.getLocation().equalsIgnoreCase("kerala"))
//                .collect(Collectors.toSet());
//           mallus.forEach(System.out::println);

        /*
          // modifying the original trainees
        Set<Trainee> mallus1=trainees
                .stream()
                .filter(t-> !t.getLocation().equalsIgnoreCase("kerala"))
                .map(t->{  // modifies and  return
                    t.setLocation("kerala");
                    return t;
                })
                //.peek(t->t.setLocation("kerala")) // modify obj but not returns
                .collect(Collectors.toSet());
        mallus1.forEach(System.out::println);
        trainees.forEach(System.out::println);

         */

        //without modifying the original trainees set
        var mallus2=trainees
                .stream()
                .filter(t-> !t.getLocation().equalsIgnoreCase("kerala"))
                .map(t-> new Trainee(t.getId(),t.getName(),"kerala"))
                .toList();

        mallus2.forEach(System.out::println);
        trainees.forEach(System.out::println);

    }
}
