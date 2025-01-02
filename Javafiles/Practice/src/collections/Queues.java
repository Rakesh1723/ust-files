package collections;

import java.util.*;

public class Queues {
    public static void main(String[] args) {
        Queue<String> q=new LinkedList<>(); // using linkedlist we can access from both sides as it implements doublelinkedlist.
        Queue<String> dq=new ArrayDeque<>();  // takes less space.
        Queue<String> pq=new PriorityQueue<>(Comparator.reverseOrder()); // sorted order.
        q.offer("ram"); // q.add()
        q.offer("sai");
        q.offer("hello");
        q.offer("world");
        while(!q.isEmpty())
        {
            System.out.println(q.poll());//q.remove()
        }
    }
}
