package java8features.defaultandstaticmethods;

interface Printer{
//    private void  prints(){
//        no use as it not call from outside, the only way to call is using inside default method ;
//    }
    void print();
    default void scan(){  // default is keyword and non-abstract method, so it is not mandatory to implement by child classes.default has one drawback of multiple inheritance.
       // if 2 interfaces has same default method then it default method overrides and more powerful class default method  is implemented.
        System.out.println("Scanner not supported 11 ...");
    }
    static void fun(){ // we cannot override static methods . just call by interface name.method().
        System.out.println("have fun");
    }
}

interface Printer1{
     default void scan(){
         System.out.println("Scanner not supported 1 ...");
     }
}
public class AdvancePrinter implements Printer,Printer1 {
     public void print(){  //child class doesn't reduce visibility by removing public.
         System.out.println("Hello advanced printer");
     }
     public void scan(){
         System.out.println("Enhanced Scanner...");
     }

    public static void main(String[] args) {
        Printer mp=new BasicPrinter();
        mp.print();
        mp.scan();
        Printer.fun();
    }
}

class BasicPrinter implements Printer{
    @Override
    public void print() {
        System.out.println("hello Basic printer");
    }
}
