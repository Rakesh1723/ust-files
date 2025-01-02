package multithreading;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSync {

//    public static synchronized  void printScores(String player, List<Integer> scores){
//        //synchronized method all  stmts inside method  are synchronized.
//            System.out.println("Scores of " + player);
//            scores.forEach(s -> System.out.println(s));
//    }


//    public  void printScores(String player, List<Integer> scores){
//       //synchronized block only stmts inside this block are synchronized.
//       synchronized (this) {
//           System.out.println("Scores of " + player);
//           scores.forEach(s -> System.out.println(s));
//       }
//    }


    Lock lock =new ReentrantLock();
    public  void printScores(String player, List<Integer> scores){
       // modern way to synchronize using locks.
           lock.lock();
           System.out.println("Scores of " + player);
           scores.forEach(s -> System.out.println(s));
           lock.unlock();
    }

    public static void main(String[] args) {
        ThreadSync ts=new ThreadSync();
        List<Integer> sachinScores=List.of(85,128,144,161,130);
        List<Integer> viratScores=List.of(97,28,44,61,30);
        Thread t1=new Thread(()->ts.printScores("Sachin",sachinScores));
        Thread t2=new Thread(()->ts.printScores("Virat",viratScores));
        t1.start();
        t2.start();

    }
}
