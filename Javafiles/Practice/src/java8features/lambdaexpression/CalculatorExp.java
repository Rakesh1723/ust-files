package java8features.lambdaexpression;

interface Calculator{
    int add(int a,int b);
}

interface MathOperation{
    int doCalculate(int a,int b);
}

class  Calculators{
    int calculate(int a,int b,MathOperation operation){
        return  operation.doCalculate(a,b);
    }
}
public class CalculatorExp {
    public static void main(String[] args) {
        // Calculator cal=(a,b)->a+b // single stmt doesn't required return .
        Calculator cal=(a,b) ->{
            int sum=a+b;
            return sum;
        };

        Calculators calc=new Calculators();
        //using lambda we can achieve functional programing.(passing fun to a  fun ) indirectly passing object .
        int sum=calc.calculate(10,5,(a,b)->a+b);
        int product=calc.calculate(10,5,(a,b)->a*b);
        int largest=calc.calculate(20,10,(a,b)->a>b?a:b);
        int gcd=calc.calculate(6,4,(a,b)->{
            int g=1;
            int larger=a>b?a:b;
            for(int i=1;i<=larger;i++){
                if(a%i==0 && b%i==0)
                    g=i;
            }
            return g;
        });
        System.out.println(gcd);
    }
}
