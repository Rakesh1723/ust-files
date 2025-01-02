import java.util.*;
public class CurrencyConverter {
    public static void main(String[] args)
    {   Scanner sc=new Scanner(System.in);
        System.out.println("""
        Welcome to the Currency Converter!
        Supported currencies:
        1.USD
        2.EUR
        3.GBP
        4.JPY
        """);
        System.out.println("Select the source currency:");
        int vals =sc.nextInt();
        System.out.println("select the target currency");
        int valt =sc.nextInt();
        System.out.println("Enter the amount you want to convert");
        while(!sc.hasNextInt())
        { System.out.println("Enter  valid amount you want to convert");
            sc.next();
        }
        float amt=sc.nextFloat();
        float output=switch(vals)
        {
            case 1->convertor(83.79f,amt,"USD");
            case 2->convertor(92.85f, amt,"EUR");
            case 3->convertor(108.99f, amt,"GBP");
            case 4-> convertor(0.57f,amt,"JPY");
            default ->{
                System.out.println("Invalid choice");
                yield 0;
            }
        };
         switch(valt)
        {     case 1:
             { System.out.println(output*0.012);
                break;}
              case 2: {
                  System.out.println(output*0.011);
                  break;
              }
              case 3: {
                  System.out.println(output*0.0092);
                  break;
              }
              case 4:
              { System.out.println(output*1.75);
                  break;
              }
            default:
                System.out.println("Invalid choice");
        }
    }
    public static float  convertor(float num, float amt, String s)
    {
         return num*amt;
    }
}

// 0.012 0.011  0.0092 1.75
