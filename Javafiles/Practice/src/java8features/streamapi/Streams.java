package java8features.streamapi;

import java.util.List;

public class Streams {
    public static void main(String[] args) {

         int $abc=5;
        List<Integer> list=List.of(1,5,9,21,2,3,4,5,6);
//        list.forEach(i-> System.out.println(i));
//        list.forEach(i-> System.out.println(i));
//        list.stream().forEach(i -> System.out.println(i)); //stream can apply only once on same
//        list.stream().forEach(i -> System.out.println(i));

       var sum=list.stream().filter(i->i%2==0)
                  .map(i->i*i)
                  .reduce((a,b)->a+b)
                  .get();
        System.out.println(sum);

        var firstEven =list.stream().filter(i->
        {
            System.out.println("filtered :"+i);
            return i%2==0;
        })
                .map(i->i*i)
                .findFirst()
               // .get(); //it returns element  or else the optional exception if element doesn't exists
                .orElse(0); //used to return default val using optional class
        //.orElseThrow(()->new ArithmeticException("no such element"));  //used to throw our own exception.
    }
}
