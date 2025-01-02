import java.util.ArrayList;
import java.util.Random;

public class Arrays {
    public static void main(Strings[] args) {

        Random rand=new Random();

        //single dimensional
        int arr1[]=new int[5];
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]= rand.nextInt(90)+10;
        }

        for(int i:arr1)
            System.out.print(i+"\t");

        //multidimensional
        int [][]arr=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for(int []rows:arr)
        { for(int i:rows)
            System.out.println(i+"\t");
        }

        //jacked arrays
        int[][] jaggedArray = {{1, 2, 3}, {4, 5},{6, 7, 8, 9} };
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
