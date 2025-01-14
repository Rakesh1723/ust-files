package collections.model;

import java.util.Comparator;

public class Task { //implements Comparable<Task> {
    private String title;
    private int priority;
    private Status status;

    public Task(String title, int priority, Status status) {
        this.title = title;
        this.priority = priority;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }

 /*   @Override
    public int compareTo(Task t) {

//        if(t.priority==this.priority)
//        {
//           return this.status.compareTo(t.status);
//        }

        return t.priority-this.priority; //descending order t-this

       // return Integer.compare(this.priority, t.priority);  //  this(current) - t(prev/head)  (ascending order) //pq -> add elements +ve<--- (HE) -ve--->
    }
*/

}
