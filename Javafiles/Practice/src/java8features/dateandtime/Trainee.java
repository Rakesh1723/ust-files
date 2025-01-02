package java8features.dateandtime;

import java.time.LocalDate;
import java.util.Date;

public final class Trainee {
    private int id;
    private String name;
  //  private Date dateJoined;
     private LocalDate dateJoined;

    public Trainee(int id, String name, LocalDate dateJoined) {
        this.id = id;
        this.name = name;
        this.dateJoined = dateJoined;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*
    public Date getDateJoined() {
      //  return  dateJoined; // it makes mutable even though we make class as immutable by doing getters and final.
        return new Date(dateJoined.getYear(),dateJoined.getMonth(),dateJoined.getDay()); //it makes immutable class.
    }*/

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateJoined=" + dateJoined +
                '}';
    }
}
