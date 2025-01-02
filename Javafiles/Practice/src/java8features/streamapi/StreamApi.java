package java8features.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static List<Integer> getEvens(List<Integer> list){
        List<Integer> evens=new ArrayList<>();
        list.forEach(a->{
            if(a%2==0)
                evens.add(a);
        });
        return evens;
    }
    public static List<Integer> getSquares(List<Integer> list){
        List<Integer> squares=new ArrayList<>();
        list.forEach(i->squares.add(i*i));
        return squares;
    }
    static int getSum(List<Integer> list){
        int sum=0;
         for(int i:list)
             sum=sum+i;
        return sum;
    }
    public static void main(String[] args){
       List<Integer> list=List.of(2,3,4,5,6);
        var even=getEvens(list);
        var squares=getSquares(even);
        var sum1=getSum(squares);
        int sum=list.stream().filter(i->i%2==0).mapToInt(i->i*i).sum();
     //   System.out.println(sum);
        var firstEven=list.stream()
                .peek(i->System.out.println("Filtered "+i))
                .filter(i->i%2==0)
                .map(i->i*i)
                .peek(i-> System.out.println("Mapped "+i));
               // .reduce(0,).toList();

    }

}
