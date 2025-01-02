import java.util.*;
public class GuessNumber {
    public static void main(Strings[] args)
    {
        System.out.println("Welcome to the Mysterious Number Guesser!");
        System.out.println("I have selected a number between 1 and 100.can you guess it ?");
        int rand=(int)(Math.random()*100)+1;    //new Random().nextInt(100)+1;
        boolean temp=false;
        Scanner sc=new Scanner(System.in);
        final int maxi=5;
        int count=0;
        while(count!=maxi){
            System.out.print("Enter your guess:");
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                if(val>=0 && val<=100)
                    count++;
                int dif = val - rand ;
                if (dif == 0) {
                    System.out.println("Congratulation! You guessed the mysterious number!");
                    temp = true;
                    break;
                } else if (dif <= 10 && dif >= -10) {
                    if(count > maxi/2){
                        if(dif > 0) {
                            System.out.println("you are forward");
                        }
                        else {
                            System.out.println("you are backward");
                        }
                    }
                    else
                     System.out.println("You're getting close!");
                } else {
                    if(count > maxi/2) {
//                        if (dif > 0) {
//                            System.out.println("you are forward");
//                        } else {
//                            System.out.println("you are backward");
//                        }
                             System.out.println("first digit is:"+ rand/10);
                    }
                    else
                         System.out.println("You're far away!");
                }
            } else {
                System.out.println("Error: Enter a valid number");
                sc.next();
            }
        }
        if (!temp) {
            System.out.println("max attempts are over");
        }
    }
}
