package exceptionhandling;

import java.io.OutputStream;

public class MultiCatch {
    public static void main(String[] args) {

        int arr[]={2,3,0};
        try{
            int output=arr[0]/arr[2];}
//        catch(RuntimeException ex)   // cannot write super exception before subtype . but super can write after subtype.
//       {
//            System.out.println(ex); }

        catch(ArithmeticException ex)
        {
            System.out.println(ex);
        }catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }catch(RuntimeException ex)
        {
            System.out.println(ex);
        }
    }
}
