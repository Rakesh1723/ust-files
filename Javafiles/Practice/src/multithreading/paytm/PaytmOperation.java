package multithreading.paytm;

import java.util.Scanner;

public class PaytmOperation {
    static boolean flag=true;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("enter bill amount");
        Scanner s=new Scanner(System.in);
        double amount=s.nextDouble();
        PaytmWallet pw=new PaytmWallet(100);

        Thread t1=new Thread(()->pw.paybill(amount));
        Thread t2=new Thread(()->{
        while (flag) {
            double amt = s.nextDouble();
            pw.addMoney(amt,amount);
        }
    });
         t1.start();
         t2.start();

    }

}
class PaytmWallet{
    double balance;

    public PaytmWallet(double balance) {
        this.balance = balance;
    }

    synchronized void addMoney(double amount,double amt){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        balance=balance+amount;
        if (balance>=amt){
            PaytmOperation.flag=false;
        }
            notifyAll();
    }

    synchronized void paybill(double amount){
        try {
            while(balance < amount)
           {
               System.out.println("please add amount to enter as balance is insufficient");
               System.out.println("current balance : "+balance);
               wait(); //wait belong to object class , one can wake it up before wait time , belongs to all waiting threads but sleep belong to thread class,no one can wake it up before sleep time,belong to particular thread.
           }
            balance=balance-amount;
            System.out.println("transaction completed");
//            PaytmOperation.flag=false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}