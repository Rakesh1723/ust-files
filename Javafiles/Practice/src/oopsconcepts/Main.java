package oopsconcepts;

public class Main {
    public static void main(String[] args)
    {
//        Person p=new Person();
//        p.setName("ram");
//        p.setAge(22);
//        p.setLocation("hyd");
//
//        Person p2=new Person("sai",21,"Bangalore");
//        System.out.println(p);
//        System.out.println(p2);
//        p.eat();

        Person person1 = new Employee();
        person1.sayHello();
        person1 = new Person();
        person1.sayHello();

        Person person2 =new Employee("ram",21,"hyd",101,20000f); //auto type casting (promotion)
        System.out.println(person2);
    }
}
