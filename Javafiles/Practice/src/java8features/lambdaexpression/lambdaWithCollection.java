package java8features.lambdaexpression;

import java.util.List;

public class lambdaWithCollection {
    public static void main(String[] args) {
        List<Integer> list=List.of(10,20,30,40,50,60,55,80);
        list.forEach((value)-> System.out.println(value)); //consumer interface no return type,internal foreach  function for collection .(faster)--j8
    }
}
