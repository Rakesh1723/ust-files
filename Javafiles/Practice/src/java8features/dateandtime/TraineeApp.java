package java8features.dateandtime;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//java provides 2 date apis. Date,local date.
//deep copy(when calling it gives new reference)
//java follows shall copy(when calling it gives same reference)
public class TraineeApp {
    public static void main(String[] args) {
//        Trainee t1=new Trainee(1,"sai",new Date(2024-1900,8,18));
//        System.out.println(t1);
//        t1.getDateJoined().setYear(2000-1900);
//        System.out.println(t1);
      //  Trainee t=new Trainee(1,"sai", LocalDate.parse("2024-08-20"));
      //  System.out.println(t);

        Trainee t1=new Trainee(1,"charan", LocalDate.parse("2024-08-20"));
        Trainee t2=new Trainee(2,"Bharat", LocalDate.parse("2024-08-10"));
        Trainee t3=new Trainee(3,"Amit", LocalDate.parse("2023-04-20"));
        Trainee t4=new Trainee(4,"Dhruv", LocalDate.parse("2024-08-25"));
        Trainee t5=new Trainee(5,"Rahul", LocalDate.parse("2022-10-15"));

        List<Trainee> list=List.of(t1,t2,t3,t4,t5);
        Trainee senior=list.stream().min((tr1,tr2)->tr1.getDateJoined().compareTo(tr2.getDateJoined())).get();
        System.out.println(senior);

    }
}
