package generics;

// generics are compile time
class Calculator<T>{

   private T value;

    public Calculator(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T doubleValue(){
//        if (value instanceof Integer) {
//            Integer n = (Integer) value;
//            return (T) Integer.valueOf(n * 2);
//        }
      return  switch(value){  //switch expression with pattern matching
          case Integer i->(T)Integer.valueOf(i*2);
          case String str->(T)(str+str);
          default->value;
      };
    }

}
public class Generics {
    public static void main(String[] args) {
      //  Calculator cal=new Calculator();
      //  cal.setValue(10);
      //  System.out.println(cal.doubleValue());
        Calculator<Integer> cal1=new Calculator(10);
        Calculator<Double> cal2=new Calculator("hello");
        System.out.println(cal1.doubleValue());
        System.out.println(cal2.doubleValue());

        Calculator<?> cal3=new Calculator<>(1);// general wildcard -> accept anything.
        Calculator<? extends Number> cal4=new Calculator<>(80); // upper bound wildcard -> accept only below Number class types.
        Calculator<? super Number> cal5=new Calculator<>("hello"); // lower bound wildcard -> accept only above Number class types .
        System.out.println(cal3.doubleValue());
        System.out.println(cal4.doubleValue());
        System.out.println(cal5.doubleValue());

    }
}
