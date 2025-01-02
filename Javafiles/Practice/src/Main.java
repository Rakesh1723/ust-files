
interface X{
     void run();
}

interface Y{
    void display();
}

interface Z extends Y{

}

class A implements X,Y{

    @Override
    public void run() {
        System.out.println("class A");
    }
    public void display(){
        System.out.println("display A");
    }
}

public class Main {
    public static void main(Strings[] args) {

           Y obj= new A();
           ((A) obj).run();
            obj.display();

    }

}