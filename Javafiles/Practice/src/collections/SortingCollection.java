package collections;
import collections.model.Trainee;
import java.util.*;

//class CompareById implements Comparator<Trainee>{
//    public int compare(Trainee t1, Trainee t2) {
//        return t2.getId()-t1.getId();
//    }
//}

//class CompareByName implements Comparator<Trainee>{
//    public int compare(Trainee t1, Trainee t2) {
//        return t1.getName().compareTo(t2.getName());
//    }
//}

public class SortingCollection {

    public static void main(String[] args) {

        Trainee t1 = new Trainee(1,"Manya","Telangana");
        Trainee t2 = new Trainee(2,"Russel","Tamilnadu");
        Trainee t3 = new Trainee(4,"Joel","Kerala");
        Trainee t4 = new Trainee(3,"Joel","Kerala");

        List<Trainee> list = new ArrayList<>(List.of(t1,t2,t3,t4));

        // list.stream().sorted().forEach(System.out::println); //default natural ordering.
        // list.sort((tr1, tr2) -> tr1.getId()-tr2.getId());
        // list.forEach(System.out::println);

// Anonymous class
//        Comparator<Trainee> compareById = new Comparator<Trainee>() {
//            public int compare(Trainee t1, Trainee t2) {
//                return t1.getId()-t2.getId();
//            }
//        };
//
//        Collections.sort(list,compareById);
//        System.out.println(list);


     //   CompareByName compByName = new CompareByName();
//        CompareById compareById = new CompareById();
//        Set<Trainee> set = new TreeSet<>(compareById);
//        set.addAll(List.of(t1,t2,t3,t4));
//        set.forEach(System.out::println);


    }

}
