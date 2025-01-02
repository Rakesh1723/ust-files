package collections;

import collections.model.Status;
import collections.model.Task;

import java.util.*;

public class Todo {

//    private Queue<String> taskqueue=new LinkedList<>();
//    private Stack<String> completedTask=new Stack<>();
//    public void addTask(){
//        taskqueue.offer("learn java");
//        taskqueue.offer("learn python");
//        taskqueue.offer("learn swimming");
//        taskqueue.offer("join gym");
//    }
//    public void processTasks(){
//        while(!taskqueue.isEmpty()){
//            String currentTask=taskqueue.poll();
//            System.out.println(currentTask);
//            completedTask.push(currentTask);
//        }
//    }
//    public void displayPastCompletedTasks(){
//        while(!completedTask.isEmpty())
//        {
//            System.out.println(completedTask.pop()+" : completed");
//        }

    private Queue<Task> pq=new PriorityQueue<>((t1,t2) -> t1.getPriority()-t2.getPriority());
           // Comparator.comparingInt(Task::getPriority)
           // (t1,t2)->t1.getPriority()-t2.getPriority()
           // (t1, t2) -> Integer.compare(t1.getPriority(),t2.getPriority())
           // Comparator.reverseOrder()

    private Stack<Task> completedTask=new Stack<>();
    public void addTask(){
        pq.offer(new Task("learn java",1, Status.PENDING));
        pq.offer(new Task("learn python",4, Status.PENDING));
        pq.offer(new Task("learn swimming",3, Status.PENDING));
        pq.offer(new Task("join gym",2,Status.PENDING));
    }
    public void processTasks(){
        while(!pq.isEmpty()){
            Task currentTask=pq.poll();
            System.out.println(currentTask.getTitle()+" : completed");
            completedTask.push(currentTask);
        }
    }
    public void displayPastCompletedTasks(){
        while(!completedTask.isEmpty())
        {   completedTask.peek().setStatus(Status.COMPLETED);
            System.out.println(completedTask.pop()+" : completed");
        }

    }

    public static void main(String[] args) {
        Todo t=new Todo();
        t.addTask();
        t.processTasks();
        t.displayPastCompletedTasks();
    }
}
