package java8features.streamapi;

import collections.model.Trainee;

import java.util.List;
import java.util.Set;

record Trainee1(int id, String name, List<String> programmingLanguages) {
}


public class TraineeExp {
    public static void main(String[] args) {

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

     //   mallus2.forEach(System.out::println);
     //   trainees.forEach(System.out::println);
        flatmap();

    }

    public static void flatmap(){
        List<Trainee1> trainees1 = List.of(
                new Trainee1(1, "Suhel", List.of("Java", "Python")),
                new Trainee1(2, "Abhishek", List.of("Java", "C++")),
                new Trainee1(3, "Sahithi", List.of("Java", "Python", "C++")));

        // find all languages that different trainees know

        var languages = trainees1.stream().flatMap(t->t.programmingLanguages().stream()).distinct().toList();
        System.out.println(languages);
    }
}
